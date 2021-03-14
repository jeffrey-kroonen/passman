package nl.agilicy.passman.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import nl.agilicy.passman.model.PasswordEntryField;

/**
 * PasswordEntryFieldDao
 */
public interface PasswordEntryFieldDao {

    boolean createPasswordEntryField(PasswordEntryField passwordEntryField, UUID passwordEntryId);

    List<PasswordEntryField> getPasswordEntryFields(UUID passwordEntryId);

    Optional<PasswordEntryField> getPasswordEntryFieldById(UUID id);

    Optional<PasswordEntryField> getPasswordEntryFieldById(UUID id, UUID passwordEntryId);

    boolean updatePasswordEntryField(UUID id, PasswordEntryField passwordEntryField, UUID passwordEntryId);

    boolean deletePasswordEntryField(UUID id, UUID passwordEntryId);
}