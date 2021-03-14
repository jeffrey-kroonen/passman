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
import org.springframework.web.bind.annotation.RestController;

import nl.agilicy.passman.model.Directory;
import nl.agilicy.passman.service.DirectoryService;

@RequestMapping("api/v1/directory")
@RestController
public class DirectoryController {
    
    private final DirectoryService directoryService;

    @Autowired
    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
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
    public Directory getDirectoryById(@PathVariable("id") UUID id) {
        return this.directoryService.getDirectoryById(id).orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateDirectory(@PathVariable("id") UUID id, @RequestBody Directory directory) {
        this.directoryService.updateDirectory(id, directory);
    }

    @DeleteMapping(path = "{id}")
    public void deleteDirectory(@PathVariable("id") UUID id) {
        this.directoryService.deleteDirectory(id);
    }

}
