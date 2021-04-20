package nl.agilicy.passman.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import nl.agilicy.passman.exception.http.BadRequestException;
import nl.agilicy.passman.exception.http.NotFoundException;
import nl.agilicy.passman.model.Directory;
import nl.agilicy.passman.model.PasswordEntry;
import nl.agilicy.passman.service.DirectoryService;
import nl.agilicy.passman.service.PasswordEntryService;
import nl.agilicy.passman.service.UserService;

@Controller
public class DirectoryViewController {

    private final DirectoryService directoryService;

    private final PasswordEntryService passwordEntryService;

    public DirectoryViewController(DirectoryService directoryService, PasswordEntryService passwordEntryService, UserService userService) {
        this.directoryService = directoryService;
        this.passwordEntryService = passwordEntryService;
    }
    
    @GetMapping("/directory/{id}")
    public String show(@PathVariable("id") Long id, Model model) throws NotFoundException {

        Directory directory = this.directoryService.getDirectoryById(id).orElse(null);

        if (Objects.isNull(directory)) {
            throw new NotFoundException();
        }

        model.addAttribute("headTitle", "directory");
        model.addAttribute("navActive", "directory");
        model.addAttribute("directories", this.directoryService.getDirectories());
        model.addAttribute("newDirectory", new Directory());
        model.addAttribute("directory", directory);
        model.addAttribute("passwordEntries", this.passwordEntryService.getPasswordEntriesForViewDirectory(id));
        model.addAttribute("newPasswordEntry", new PasswordEntry());

        return "directory/show";
    }

    @PostMapping("/directory")
    public String addDirectory(@ModelAttribute Directory directoryToAdd) {
        this.directoryService.createDirectory(directoryToAdd);

        return "redirect:/directory/" + this.directoryService.getLast().getId();
    }

    @PutMapping("/directory/{id}")
    public String updateDirectory(@PathVariable("id") Long id, @ModelAttribute Directory directoryToUpdate) throws BadRequestException {
        Directory directory = this.directoryService.getDirectoryById(id).orElse(null);

        if (Objects.isNull(directory)) {
            throw new BadRequestException();
        }

        this.directoryService.updateDirectory(id, directoryToUpdate);

        return "redirect:/directory/" + id;
    }

    @DeleteMapping("/directory/{id}")
    public String deleteDirectory(@PathVariable("id") Long id) throws BadRequestException {
        Directory directory = this.directoryService.getDirectoryById(id).orElse(null);

        if (Objects.isNull(directory)) {
            throw new BadRequestException();
        }

        this.directoryService.deleteDirectory(id);

        return "redirect:/";
    }
}
