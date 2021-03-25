package nl.agilicy.passman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardViewController {

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("headTitle", "dashboard");
        model.addAttribute("navActive", "dashboard");

        return "dashboard/index";
    }
    
}
