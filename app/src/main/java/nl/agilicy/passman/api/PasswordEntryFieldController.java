package nl.agilicy.passman.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.agilicy.passman.model.PasswordEntryField;
import nl.agilicy.passman.service.PasswordEntryFieldService;

@RequestMapping("api/v1/password-entry-field")
@RestController
public class PasswordEntryFieldController {
    
    private final PasswordEntryFieldService passwordEntryFieldService;

    @Autowired
    public PasswordEntryFieldController(PasswordEntryFieldService passwordEntryFieldService) {
        this.passwordEntryFieldService = passwordEntryFieldService;
    }

    @GetMapping(path = "{id}")
    public PasswordEntryField getPasswordEntry(@PathVariable("id") Long id) {
        return this.passwordEntryFieldService.getPasswordEntryFieldById(id).orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updatePasswordEntryField(@PathVariable("id") Long id, @RequestBody PasswordEntryField passwordEntryField) {
        this.passwordEntryFieldService.updatePasswordEntryField(id, passwordEntryField);
    }

    @DeleteMapping(path = "{id}")
    public void deletePasswordEntryField(@PathVariable("id") Long id) {
        this.passwordEntryFieldService.deletePasswordEntryField(id);
    }
}
