package nl.agilicy.passman.model;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class Permission {
    enum PermissionType {
        READ,
        WRITE,
        DELETE
    }

    private int id;

    private User user;

    private Directory directory;

    private PermissionType permission_type;

    private Timestamp created_at;

    private Timestamp updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public PermissionType getPermission_type() {
        return permission_type;
    }

    public void setPermission_type(PermissionType permission_type) {
        this.permission_type = permission_type;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    /** 
     * Get PermissionTypes as List.
     */ 
    public List<PermissionType> getPermissionTypes() {
        return Arrays.asList(PermissionType.values());
    }
}
