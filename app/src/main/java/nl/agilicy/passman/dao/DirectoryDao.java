package nl.agilicy.passman.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import nl.agilicy.passman.model.Directory;

/**
 * 
 */
public interface DirectoryDao {

    boolean createDirectory(Directory directory);
    
    List<Directory> getDirectories();

    Optional<Directory> getDirectoryById(UUID id);

    boolean updateDirectory(UUID id, Directory directory);

    boolean deleteDirectory(UUID id);
}

