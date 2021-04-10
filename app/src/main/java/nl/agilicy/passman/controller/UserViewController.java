package nl.agilicy.passman.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import nl.agilicy.passman.exception.http.BadRequestException;
import nl.agilicy.passman.model.Directory;
import nl.agilicy.passman.model.User;
import nl.agilicy.passman.service.DirectoryService;
import nl.agilicy.passman.service.UserService;

@Controller
public class UserViewController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final DirectoryService directoryService;


    public UserViewController(UserService userService, DirectoryService directoryService) {
        this.userService = userService;
        this.directoryService = directoryService;
    }

    @GetMapping("/user")
    public String index(Model model) {
        model.addAttribute("headTitle", "gebruikers");
        model.addAttribute("navActive", "manage");
        model.addAttribute("newDirectory", new Directory());
        model.addAttribute("directories", this.directoryService.getDirectories());
        model.addAttribute("users", this.userService.getUsers());
        model.addAttribute("user", new User());

        return "user/index";
    }

    @PostMapping("/user")
    public String createUser(@ModelAttribute User userToAdd) {

        // Todo: Get user by email to check if user already exists.

        this.userService.createUser(userToAdd);

        return "redirect:/user";
    }

    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User userToUpdate) throws BadRequestException {
        User user = this.userService.getUserById(id).orElse(null);

        if (Objects.isNull(user)) {
            throw new BadRequestException();
        }

        this.userService.updateUser(id, userToUpdate);

        return "redirect:/user";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) throws BadRequestException {
        User user = this.userService.getUserById(id).orElse(null);

        if (Objects.isNull(user)) {
            throw new BadRequestException();
        }

        this.userService.deleteUser(id);

        return "redirect:/user";
    }
 
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        model.addAttribute("headTitle", "login");

        if (error != null) {
            model.addAttribute("error", "Het e-mailadres en wachtwoord zijn niet juist.");
        }
            

        if (logout != null) {
            model.addAttribute("message", "Je bent uitgelogd.");
        }
            

        return "user/login";
    }

}
