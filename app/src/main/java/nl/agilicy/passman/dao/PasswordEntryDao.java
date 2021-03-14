package nl.agilicy.passman.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import nl.agilicy.passman.model.PasswordEntry;

/**
 * PasswordEntryDao
 */
public interface PasswordEntryDao {

    boolean createPasswordEntry(PasswordEntry passwordEntry, UUID directoryId);

    List<PasswordEntry> getPasswordEntries(UUID directoryId);

    Optional<PasswordEntry> getPasswordEntryById(UUID id);

    Optional<PasswordEntry> getPasswordEntryById(UUID id, UUID directoryId);

    boolean updatePasswordEntry(UUID id, PasswordEntry passwordEntry, UUID directoryId);

    boolean deletePasswordEntry(UUID id, UUID directoryId);
}