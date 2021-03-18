package nl.agilicy.passman.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.agilicy.passman.model.PasswordEntry;
import nl.agilicy.passman.service.PasswordEntryService;

@RequestMapping("api/v1/password-entry")
@RestController
public class PasswordEntryController {
    
    private final PasswordEntryService passwordEntryService;

    @Autowired
    public PasswordEntryController(PasswordEntryService passwordEntryService) {
        this.passwordEntryService = passwordEntryService;
    }

    @GetMapping(path = "{id}")
    public PasswordEntry getPasswordEntryById(@PathVariable("id") Long id) {
        return this.passwordEntryService.getPasswordEntryById(id).orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updatePasswordEntry(@PathVariable("id") Long id, @RequestBody PasswordEntry passwordEntry) {
        this.passwordEntryService.updatePasswordEntry(id, passwordEntry);
    }

    @DeleteMapping(path = "{id}")
    public void deletePasswordEntry(@PathVariable("id") Long id) {
        this.passwordEntryService.deletePasswordEntry(id);
    }
}
