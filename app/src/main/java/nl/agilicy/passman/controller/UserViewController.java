package nl.agilicy.passman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nl.agilicy.passman.model.Directory;
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

        return "user/index";
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
