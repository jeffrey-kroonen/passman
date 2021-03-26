package nl.agilicy.passman.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nl.agilicy.passman.model.Directory;
import nl.agilicy.passman.service.DirectoryService;

@Controller
public class DashboardViewController {

    private final DirectoryService directoryService;

    private List<Directory> directories;

    public DashboardViewController(DirectoryService directoryService) {
        this.directoryService = directoryService;
        this.directories = this.directoryService.getDirectories();
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("headTitle", "dashboard");
        model.addAttribute("navActive", "dashboard");
        model.addAttribute("directories", this.directories);

        return "dashboard/index";
    }
    
}
