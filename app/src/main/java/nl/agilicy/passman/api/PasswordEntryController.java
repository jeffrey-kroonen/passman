package nl.agilicy.passman.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.agilicy.passman.model.PasswordEntry;
import nl.agilicy.passman.model.PasswordEntryField;
import nl.agilicy.passman.service.PasswordEntryFieldService;
import nl.agilicy.passman.service.PasswordEntryService;

@RequestMapping("api/v1/password-entry")
@RestController
public class PasswordEntryController {
    
    private final PasswordEntryService passwordEntryService;

    private final PasswordEntryFieldService passwordEntryFieldService;

    @Autowired
    public PasswordEntryController(PasswordEntryService passwordEntryService, PasswordEntryFieldService passwordEntryFieldService) {
        this.passwordEntryService = passwordEntryService;
        this.passwordEntryFieldService = passwordEntryFieldService;
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

    @PostMapping(path = "{id}/password-entry-field")
    public void createPasswordEntryField(@RequestBody PasswordEntryField passwordEntryField, @PathVariable("id") Long id) {
        this.passwordEntryFieldService.createPasswordEntryField(passwordEntryField, id);
    }

    @GetMapping(path = "{id}/password-entry-field")
    public Set<PasswordEntryField> getPasswordEntryFields(@PathVariable("id") Long id) {
        return this.passwordEntryFieldService.getPasswordEntryFields(id);
    }
}
