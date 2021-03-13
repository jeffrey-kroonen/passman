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

import nl.agilicy.passman.model.PasswordEntry;
import nl.agilicy.passman.service.PasswordEntryService;

@RequestMapping("api/v1/directory/{directoryId}/password-entry")
public class PasswordEntryController {
    
    private final PasswordEntryService passwordEntryService;

    @Autowired
    public PasswordEntryController(PasswordEntryService passwordEntryService) {
        this.passwordEntryService = passwordEntryService;
    }

    @PostMapping
    public void createPasswordEntry(@RequestBody PasswordEntry passwordEntry, @PathVariable("directoryId") UUID directoryId) {
        this.passwordEntryService.createPasswordEntry(passwordEntry, directoryId);
    }

    @GetMapping
    public List<PasswordEntry> getPasswordEntries(@PathVariable("directoryId") UUID directoryId) {
        return this.passwordEntryService.getPasswordEntries(directoryId);
    }

    @GetMapping(path = "{id}")
    public PasswordEntry getPasswordEntry(@PathVariable("id") UUID id, @PathVariable("directoryId") UUID directoryId) {
        return this.passwordEntryService.getPasswordEntryById(id, directoryId).orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updatePasswordEntry(@PathVariable("id") UUID id, @RequestBody PasswordEntry passwordEntry, @PathVariable("directoryId") UUID directoryId) {
        this.passwordEntryService.updatePasswordEntry(id, passwordEntry, directoryId);
    }

    @DeleteMapping(path = "{id}")
    public void deletePasswordEntry(@PathVariable("id") UUID id, @PathVariable("directoryId") UUID directoryId) {
        this.passwordEntryService.deletePasswordEntry(id, directoryId);
    }
}
