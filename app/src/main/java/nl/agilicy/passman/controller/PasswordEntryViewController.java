package nl.agilicy.passman.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import nl.agilicy.passman.exception.http.BadRequestException;
import nl.agilicy.passman.form.models.DeletePasswordEntryForm;
import nl.agilicy.passman.form.models.passwordEntryForm;
import nl.agilicy.passman.model.PasswordEntry;
import nl.agilicy.passman.service.PasswordEntryFieldService;
import nl.agilicy.passman.service.PasswordEntryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PasswordEntryViewController {

    private final PasswordEntryService passwordEntryService;

    private final PasswordEntryFieldService passwordEntryFieldService;

    public PasswordEntryViewController(PasswordEntryService passwordEntryService, PasswordEntryFieldService passwordEntryFieldService) {
        this.passwordEntryService = passwordEntryService;
        this.passwordEntryFieldService = passwordEntryFieldService;
    }

    @PostMapping("/password-entry")
    public String postMethodName(@ModelAttribute passwordEntryForm passwordEntryForm) {
        
        PasswordEntry passwordEntry = new PasswordEntry();
        passwordEntry.setTitle(passwordEntryForm.getTitle());

        this.passwordEntryService.createPasswordEntry(passwordEntry, passwordEntryForm.getDirectoryId());
        PasswordEntry lastPasswordEntry = this.passwordEntryService.getLast();

        this.passwordEntryFieldService.createPasswordEntryFieldsByPasswordEntryId(lastPasswordEntry, passwordEntryForm.getPasswordEntryValues(), passwordEntryForm.getPasswordEntryFields(), passwordEntryForm.getPasswordEntryTypes());
        
        return "redirect:/directory/" + passwordEntryForm.getDirectoryId();
    }
    
    @DeleteMapping("/password-entry/{id}")
    public String deletePasswordEntry(@PathVariable("id") Long id, @ModelAttribute DeletePasswordEntryForm deletePasswordEntryForm) throws BadRequestException {
        PasswordEntry passwordEntry = this.passwordEntryService.getPasswordEntryById(id).orElse(null);

        if (Objects.isNull(passwordEntry)) {
            throw new BadRequestException();
        }

        this.passwordEntryService.deletePasswordEntry(id);

        return "redirect:/directory/" + deletePasswordEntryForm.getDirectoryId();
    }

    @GetMapping("/password-entry-show/{id}")
    public String showModalPasswordEntry(@PathVariable("id") Long id, Model model) {
        PasswordEntry passwordEntry = this.passwordEntryService.getPasswordEntryById(id).orElse(null);

        if (Objects.isNull(passwordEntry)) {
            throw new BadRequestException();
        }

        model.addAttribute("passwordEntry", passwordEntry);

        return "password-entry/modal";
    }
}
