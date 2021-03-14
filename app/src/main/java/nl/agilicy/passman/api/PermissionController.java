package nl.agilicy.passman.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import nl.agilicy.passman.model.Permission;
import nl.agilicy.passman.service.PermissionService;

public class PermissionController {

    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping
    public void createPermission(@RequestBody Permission permission) {
        this.permissionService.createPermission(permission);
    }

    @GetMapping
    public List<Permission> getPermissions() {
        return this.permissionService.getPermissions();
    }

    @GetMapping(path = "{id}")
    public Permission getPermissionById(@PathVariable("id") Long id) {
        // return this.permissionService.getPermissionById(id).orElse(null);
        return new Permission();
    }

    @PutMapping(path = "{id}")
    public void updatePermission(@PathVariable("id") Long id, @RequestBody Permission permissions) {
        this.permissionService.updatePermission(id, permissions);
    }

    @DeleteMapping(path = "{id}")
    public void deletePermission(@PathVariable("id") Long id) {
        this.permissionService.deletePermission(id);
    }
}
