package nl.agilicy.passman.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import nl.agilicy.passman.dao.PasswordEntryFieldDao;
import nl.agilicy.passman.model.PasswordEntryField;

@Service
public class PasswordEntryFieldService {
    
    private final PasswordEntryFieldDao passwordEntryFieldDao;

    @Autowired
    public PasswordEntryFieldService(@Qualifier("testPasswordEntryFieldDao") PasswordEntryFieldDao passwordEntryFieldDao) {
        this.passwordEntryFieldDao = passwordEntryFieldDao;
    }

    public boolean createPasswordEntryField(PasswordEntryField passwordEntryField, UUID passwordEntryId) {
        return this.passwordEntryFieldDao.createPasswordEntryField(passwordEntryField, passwordEntryId);
    }

    public List<PasswordEntryField> getPasswordEntryFields(UUID passwordEntryId) {
        return this.passwordEntryFieldDao.getPasswordEntryFields(passwordEntryId);
    }

    public Optional<PasswordEntryField> getPasswordEntryFieldById(UUID id, UUID passwordEntryId) {
        return this.passwordEntryFieldDao.getPasswordEntryFieldById(id, passwordEntryId);
    }

    public boolean updatePasswordEntryField(UUID id, PasswordEntryField passwordEntryField, UUID passwordEntryId) {
        return this.passwordEntryFieldDao.updatePasswordEntryField(id, passwordEntryField, passwordEntryId);
    }

    public boolean deletePasswordEntryField(UUID id, UUID passwordEntryId) {
        return this.passwordEntryFieldDao.deletePasswordEntryField(id, passwordEntryId);
    }
}
