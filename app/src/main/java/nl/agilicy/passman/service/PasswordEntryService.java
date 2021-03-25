package nl.agilicy.passman.service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.agilicy.passman.model.Directory;
import nl.agilicy.passman.model.PasswordEntry;
import nl.agilicy.passman.repository.DirectoryRepository;
import nl.agilicy.passman.repository.PasswordEntryRepository;

@Service
public class PasswordEntryService {
    
    private final PasswordEntryRepository passwordEntryRepository;

    private final DirectoryRepository directoryRepository;

    @Autowired
    public PasswordEntryService(PasswordEntryRepository passwordEntryRepository, DirectoryRepository directoryRepository) {
        this.passwordEntryRepository = passwordEntryRepository;
        this.directoryRepository = directoryRepository;
    }

    public boolean createPasswordEntry(PasswordEntry passwordEntry, Long directoryId) {
        Directory directory = this.directoryRepository.findById(directoryId).orElse(null);

        if (Objects.isNull(directory)) {
            return false;
        }

        passwordEntry.setDirectory(directory);

        this.passwordEntryRepository.save(passwordEntry);
        return true;
    }

    public Set<PasswordEntry> getPasswordEntries(Long directoryId) {
        Directory directory = this.directoryRepository.findById(directoryId).orElse(null);

        if (Objects.isNull(directory)) {
            return null;
        }

        return directory.getPassword_entries();
    }

    public Optional<PasswordEntry> getPasswordEntryById(Long id) {
        return this.passwordEntryRepository.findById(id);
    }

    public boolean updatePasswordEntry(Long id, PasswordEntry passwordEntryToUpdate) {
        PasswordEntry passwordEntry = this.passwordEntryRepository.findById(id).orElse(null);

        if (Objects.isNull(passwordEntry)) {
            return false;
        }

        passwordEntry.setTitle(passwordEntryToUpdate.getTitle());

        this.passwordEntryRepository.save(passwordEntry);
        return true;
    }

    public boolean deletePasswordEntry(Long id) {
        PasswordEntry passwordEntry = this.passwordEntryRepository.findById(id).orElse(null);

        if (Objects.isNull(passwordEntry)) {
            return false;
        }

        this.passwordEntryRepository.delete(passwordEntry);
        return true;
    }
}
