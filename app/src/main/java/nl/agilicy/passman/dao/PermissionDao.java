package nl.agilicy.passman.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import nl.agilicy.passman.model.Permission;

/**
 * PermissionDao
 */
public interface PermissionDao {
    
    boolean createPermission(Permission permission);

    List<Permission> getPermissions();

    Optional<Permission> getPermissionById(UUID id);

    boolean updatePermission(UUID id);

    boolean deletePermission(UUID id);
}
