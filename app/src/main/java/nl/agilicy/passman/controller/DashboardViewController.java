package nl.agilicy.passman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nl.agilicy.passman.model.Directory;
import nl.agilicy.passman.service.DirectoryService;
import nl.agilicy.passman.service.UserService;

@Controller
public class DashboardViewController {

    private final DirectoryService directoryService;

    private final UserService userService;

    public DashboardViewController(DirectoryService directoryService, UserService userService) {
        this.directoryService = directoryService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("headTitle", "dashboard");
        model.addAttribute("navActive", "dashboard");
        model.addAttribute("newDirectory", new Directory());
        model.addAttribute("directories", this.directoryService.getDirectories());
        model.addAttribute("users", this.userService.getUsers());

        return "dashboard/index";
    }
    
}
