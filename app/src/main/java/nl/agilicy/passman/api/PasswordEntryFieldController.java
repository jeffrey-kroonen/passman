package nl.agilicy.passman.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import nl.agilicy.passman.model.PasswordEntryField;
import nl.agilicy.passman.service.PasswordEntryFieldService;

@RequestMapping("api/v1/directory/{passwordEntryId}/password-entry-field")
public class PasswordEntryFieldController {
    
    private final PasswordEntryFieldService passwordEntryFieldService;

    @Autowired
    public PasswordEntryFieldController(PasswordEntryFieldService passwordEntryFieldService) {
        this.passwordEntryFieldService = passwordEntryFieldService;
    }

    @PostMapping
    public void createPasswordEntryField(@RequestBody PasswordEntryField passwordEntryField, @PathVariable("passwordEntryId") UUID passwordEntryId) {
        this.passwordEntryFieldService.createPasswordEntryField(passwordEntryField, passwordEntryId);
    }

    @GetMapping
    public List<PasswordEntryField> getPasswordEntries(@PathVariable("passwordEntryId") UUID passwordEntryId) {
        return this.passwordEntryFieldService.getPasswordEntryFields(passwordEntryId);
    }

    @GetMapping(path = "{id}")
    public PasswordEntryField getPasswordEntry(@PathVariable("id") UUID id, @PathVariable("passwordEntryId") UUID passwordEntryId) {
        return this.passwordEntryFieldService.getPasswordEntryFieldById(id, passwordEntryId).orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updatePasswordEntryField(@PathVariable("id") UUID id, @RequestBody PasswordEntryField passwordEntryField, @PathVariable("passwordEntryId") UUID passwordEntryId) {
        this.passwordEntryFieldService.updatePasswordEntryField(id, passwordEntryField, passwordEntryId);
    }

    @DeleteMapping(path = "{id}")
    public void deletePasswordEntryField(@PathVariable("id") UUID id, @PathVariable("passwordEntryId") UUID passwordEntryId) {
        this.passwordEntryFieldService.deletePasswordEntryField(id, passwordEntryId);
    }
}
