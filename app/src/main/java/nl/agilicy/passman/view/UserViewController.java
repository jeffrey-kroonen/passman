package nl.agilicy.passman.view;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import nl.agilicy.passman.model.User;
import nl.agilicy.passman.service.UserService;

@RequestMapping("user")
@Controller
public class UserViewController {

    private final UserService userService;

    @Autowired
    public UserViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {

        User user = this.userService.getUserById(id).orElse(null);

        if (Objects.isNull(user)) {
            return "redirect:/";
        }

        model.addAttribute("headTitle", "users");
        model.addAttribute("user", user);
        return "user";
    }
}
