package nl.agilicy.passman.api;

import java.util.List;
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

import nl.agilicy.passman.model.Directory;
import nl.agilicy.passman.model.PasswordEntry;
import nl.agilicy.passman.service.DirectoryService;
import nl.agilicy.passman.service.PasswordEntryService;

@RequestMapping("api/v1/directory")
@RestController
public class DirectoryController {
    
    private final DirectoryService directoryService;

    private final PasswordEntryService passwordEntryService;

    @Autowired
    public DirectoryController(DirectoryService directoryService, PasswordEntryService passwordEntryService) {
        this.directoryService = directoryService;
        this.passwordEntryService = passwordEntryService;
    }

    @PostMapping
    public void createDirectory(@RequestBody Directory directory) {
        this.directoryService.createDirectory(directory);
    }

    @GetMapping
    public List<Directory> getDirectories() {
        return this.directoryService.getDirectories();
    }

    @GetMapping(path = "{id}")
    public Directory getDirectoryById(@PathVariable("id") Long id) {
        return this.directoryService.getDirectoryById(id).orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateDirectory(@PathVariable("id") Long id, @RequestBody Directory directory) {
        this.directoryService.updateDirectory(id, directory);
    }

    @DeleteMapping(path = "{id}")
    public void deleteDirectory(@PathVariable("id") Long id) {
        this.directoryService.deleteDirectory(id);
    }

    @PostMapping(path = "{id}/password-entry")
    public void createPasswordEntry(@RequestBody PasswordEntry passwordEntry, @PathVariable("id") Long id) {
        this.passwordEntryService.createPasswordEntry(passwordEntry, id);
    }

    @GetMapping(path = "{id}/password-entry")
    public Set<PasswordEntry> getPasswordEntries(@PathVariable("id") Long id) {
        return this.passwordEntryService.getPasswordEntries(id);
    }

}
