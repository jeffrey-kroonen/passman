package nl.agilicy.passman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
 
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
