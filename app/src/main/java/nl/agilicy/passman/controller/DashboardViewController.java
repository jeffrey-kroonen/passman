package nl.agilicy.passman.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nl.agilicy.passman.model.Directory;
import nl.agilicy.passman.model.User;
import nl.agilicy.passman.service.DirectoryService;
import nl.agilicy.passman.service.UserService;

@Controller
public class DashboardViewController {

    private final DirectoryService directoryService;

    private final UserService userService;

    private List<Directory> directories;

    private List<User> users;

    public DashboardViewController(DirectoryService directoryService, UserService userService) {
        this.directoryService = directoryService;
        this.directories = this.directoryService.getDirectories();

        this.userService = userService;
        this.users = this.userService.getUsers();
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("headTitle", "dashboard");
        model.addAttribute("navActive", "dashboard");
        model.addAttribute("directories", this.directories);
        model.addAttribute("users", this.users);

        return "dashboard/index";
    }
    
}
