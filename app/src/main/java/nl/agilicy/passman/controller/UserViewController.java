package nl.agilicy.passman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
 
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("headTitle", "login");
        return "user/login";
    }
}
