package nl.agilicy.passman.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import nl.agilicy.passman.model.Directory;

/**
 * 
 */
@Repository("testDirectoryDao")
public class DirectoryDataAccessService implements DirectoryDao {

    private static List<Directory> DB = new ArrayList<Directory>();

    @Override
    public boolean createDirectory(Directory directory) {
        DB.add(directory);
        return true;
    }
    
    @Override
    public List<Directory> getDirectories() {
        return DB;
    }

    @Override
    public Optional<Directory> getDirectoryById(UUID id) {
        return DB.stream().filter(directory -> directory.getId().equals(id)).findFirst();
    }

    @Override
    public boolean updateDirectory(UUID id, Directory directoryToUpdate) {
        return getDirectoryById(id)
            .map(directory -> {
                int indexOfDirectoryToUpdate = DB.indexOf(directory);
                if (indexOfDirectoryToUpdate >= 0) {
                    DB.set(indexOfDirectoryToUpdate, directoryToUpdate);
                    return true;
                }
                return false;
            }).orElse(false);
    }

    @Override
    public boolean deleteDirectory(UUID id) {
        Optional<Directory> directory = getDirectoryById(id);

        if (!directory.isEmpty()) {
            DB.remove(directory.get());
            return true;
        }

        return false;
    }
}