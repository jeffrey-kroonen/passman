package nl.agilicy.passman.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import nl.agilicy.passman.model.PasswordEntry;

@Repository("testPasswordEntryDao")
public class PasswordEntryAccessService implements PasswordEntryDao {
    
    private static List<PasswordEntry> DB = new ArrayList<PasswordEntry>();

    @Override
    public boolean createPasswordEntry(PasswordEntry passwordEntry, UUID directoryId) {
        // Todo: Fetch Directory by ID and return false, when no Directory is found.

        DB.add(passwordEntry);
        return true;
    }

    @Override
    public List<PasswordEntry> getPasswordEntries(UUID directoryId) {
        // Todo: Fetch Directory by ID and return null when no Directory is found.
        
        return DB;
    }

    @Override
    public Optional<PasswordEntry> getPasswordEntryById(UUID id, UUID directoryId) {
        // Todo: Fetch Directory by ID and return null when no Directory is found.

        return DB.stream().filter(passwordEntry -> passwordEntry.getId().equals(id)).findFirst();
    }

    @Override
    public boolean updatePasswordEntry(UUID id, PasswordEntry passwordEntryToUpdate, UUID directoryId) {
        // Todo: Fetch Directory by ID and return false when no Directory is found.
        
        return getPasswordEntryById(id, directoryId)
            .map(passwordEntry -> {
                int indexOfPasswordEntryToUpdate = DB.indexOf(passwordEntry);
                if (indexOfPasswordEntryToUpdate >= 0) {
                    DB.set(indexOfPasswordEntryToUpdate, passwordEntryToUpdate);
                    return true;
                }
                return false;
            }).orElse(false);
    }

    @Override
    public boolean deletePasswordEntry(UUID id, UUID directoryId) {
        // Todo: Fetch Directory by ID and return false when no Directory is found.

        Optional<PasswordEntry> passwordEntry = getPasswordEntryById(id, directoryId);

        if (!passwordEntry.isEmpty()) {
            DB.remove(passwordEntry.get());
            return true;
        }

        return false;
    }

}
