package nl.agilicy.passman.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import nl.agilicy.passman.model.PasswordEntry;
import nl.agilicy.passman.model.PasswordEntryField;

@Repository("testPasswordEntryFieldDao")
public class PasswordEntryFieldAccessService implements PasswordEntryFieldDao {
    
    private static List<PasswordEntryField> DB = new ArrayList<PasswordEntryField>();

    private final PasswordEntryDao passwordEntryDao;

    @Autowired
    public PasswordEntryFieldAccessService(@Qualifier("testPasswordEntryDao") PasswordEntryDao passwordEntryDao) {
        this.passwordEntryDao = passwordEntryDao;
    }

    @Override
    public boolean createPasswordEntryField(PasswordEntryField passwordEntryField, UUID passwordEntryId) {
        PasswordEntry passwordEntry = this.passwordEntryDao.getPasswordEntryById(passwordEntryId).orElse(null);

        if (Objects.isNull(passwordEntry)) {
            return false;
        }

        DB.add(passwordEntryField);
        return true;
    }

    @Override
    public List<PasswordEntryField> getPasswordEntryFields(UUID passwordEntryId) {
        PasswordEntry passwordEntry = this.passwordEntryDao.getPasswordEntryById(passwordEntryId).orElse(null);

        if (Objects.isNull(passwordEntry)) {
            return null;
        }
        
        return DB;
    }
    
    @Override
    public Optional<PasswordEntryField> getPasswordEntryFieldById(UUID id) {
        return DB.stream().filter(passwordEntryField -> passwordEntryField.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<PasswordEntryField> getPasswordEntryFieldById(UUID id, UUID passwordEntryId) {
        PasswordEntry passwordEntry = this.passwordEntryDao.getPasswordEntryById(passwordEntryId).orElse(null);

        if (Objects.isNull(passwordEntry)) {
            return null;
        }

        return DB.stream().filter(passwordEntryField -> passwordEntryField.getId().equals(id)).findFirst();
    }

    @Override
    public boolean updatePasswordEntryField(UUID id, PasswordEntryField passwordEntryFieldToUpdate, UUID passwordEntryId) {
        PasswordEntry passwordEntry = this.passwordEntryDao.getPasswordEntryById(passwordEntryId).orElse(null);

        if (Objects.isNull(passwordEntry)) {
            return false;
        }
        
        return getPasswordEntryFieldById(id, passwordEntryId)
            .map(passwordEntryField -> {
                int indexOfPasswordEntryFieldToUpdate = DB.indexOf(passwordEntryField);
                if (indexOfPasswordEntryFieldToUpdate >= 0) {
                    DB.set(indexOfPasswordEntryFieldToUpdate, passwordEntryFieldToUpdate);
                    return true;
                }
                return false;
            }).orElse(false);
    }

    @Override
    public boolean deletePasswordEntryField(UUID id, UUID passwordEntryId) {
        PasswordEntry passwordEntry = this.passwordEntryDao.getPasswordEntryById(passwordEntryId).orElse(null);

        if (Objects.isNull(passwordEntry)) {
            return false;
        }

        Optional<PasswordEntryField> passwordEntryField = getPasswordEntryFieldById(id, passwordEntryId);

        if (!passwordEntryField.isEmpty()) {
            DB.remove(passwordEntryField.get());
            return true;
        }

        return false;
    }

}
