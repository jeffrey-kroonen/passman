package nl.agilicy.passman.model;

import java.util.UUID;

public class DirectoryLog {
    private UUID id;

    private Directory directory_id;

    private PasswordEntry password_entry_id;

    private User updated_by;
    
    private User created_by;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Directory getDirectory_id() {
        return directory_id;
    }

    public void setDirectory_id(Directory directory_id) {
        this.directory_id = directory_id;
    }

    public PasswordEntry getPassword_entry_id() {
        return password_entry_id;
    }

    public void setPassword_entry_id(PasswordEntry password_entry_id) {
        this.password_entry_id = password_entry_id;
    }

    public User getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(User updated_by) {
        this.updated_by = updated_by;
    }

    public User getCreated_by() {
        return created_by;
    }

    public void setCreated_by(User created_by) {
        this.created_by = created_by;
    }
}
