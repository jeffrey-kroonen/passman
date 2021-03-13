package nl.agilicy.passman.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import nl.agilicy.passman.dao.PasswordEntryDao;
import nl.agilicy.passman.model.PasswordEntry;

@Service
public class PasswordEntryService {
    
    private final PasswordEntryDao passwordEntryDao;

    @Autowired
    public PasswordEntryService(@Qualifier("testPasswordEntryDao") PasswordEntryDao passwordEntryDao) {
        this.passwordEntryDao = passwordEntryDao;
    }

    public boolean createPasswordEntry(PasswordEntry passwordEntry, UUID directoryId) {
        return this.passwordEntryDao.createPasswordEntry(passwordEntry, directoryId);
    }

    public List<PasswordEntry> getPasswordEntries(UUID directoryId) {
        return this.passwordEntryDao.getPasswordEntries(directoryId);
    }

    public Optional<PasswordEntry> getPasswordEntryById(UUID id, UUID directoryId) {
        return this.passwordEntryDao.getPasswordEntryById(id, directoryId);
    }

    public boolean updatePasswordEntry(UUID id, PasswordEntry passwordEntry, UUID directoryId) {
        return this.passwordEntryDao.updatePasswordEntry(id, passwordEntry, directoryId);
    }

    public boolean deletePasswordEntry(UUID id, UUID directoryId) {
        return this.passwordEntryDao.deletePasswordEntry(id, directoryId);
    }
}
