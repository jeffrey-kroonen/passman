package nl.agilicy.passman.service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.agilicy.passman.model.PasswordEntry;
import nl.agilicy.passman.model.PasswordEntryField;
import nl.agilicy.passman.repository.PasswordEntryFieldRepository;
import nl.agilicy.passman.repository.PasswordEntryRepository;

@Service
public class PasswordEntryFieldService {
    
    private final PasswordEntryFieldRepository passwordEntryFieldRepository;

    private final PasswordEntryRepository passwordEntryRepository;

    @Autowired
    public PasswordEntryFieldService(PasswordEntryFieldRepository passwordEntryFieldRepository, PasswordEntryRepository passwordEntryRepository) {
        this.passwordEntryFieldRepository = passwordEntryFieldRepository;
        this.passwordEntryRepository = passwordEntryRepository;
    }

    public boolean createPasswordEntryField(PasswordEntryField passwordEntryField, Long passwordEntryId) {
        PasswordEntry passwordEntry = this.passwordEntryRepository.findById(passwordEntryId).orElse(null);

        if (Objects.isNull(passwordEntry)) {
            return false;
        }

        passwordEntryField.setPassword_entry(passwordEntry);

        this.passwordEntryFieldRepository.save(passwordEntryField);
        return true;
    }

    public Set<PasswordEntryField> getPasswordEntryFields(Long passwordEntryId) {
        PasswordEntry passwordEntry = this.passwordEntryRepository.findById(passwordEntryId).orElse(null);

        if (Objects.isNull(passwordEntry)) {
            return null;
        }

        return passwordEntry.getPassword_entity_fields();
    }

    public Optional<PasswordEntryField> getPasswordEntryFieldById(Long id) {
        return this.passwordEntryFieldRepository.findById(id);
    }

    public boolean updatePasswordEntryField(Long id, PasswordEntryField passwordEntryFieldToUpdate) {
        PasswordEntryField passwordEntryField = this.passwordEntryFieldRepository.findById(id).orElse(null);

        if (Objects.isNull(passwordEntryField)) {
            return false;
        }

        passwordEntryField.setValue(passwordEntryFieldToUpdate.getValue());

        this.passwordEntryFieldRepository.save(passwordEntryFieldToUpdate);
        return true;
    }

    public boolean deletePasswordEntryField(Long id) {
        PasswordEntryField passwordEntryField = this.passwordEntryFieldRepository.findById(id).orElse(null);

        if (Objects.isNull(passwordEntryField)) {
            return false;
        }

        this.passwordEntryFieldRepository.delete(passwordEntryField);
        return true;
    }
}
