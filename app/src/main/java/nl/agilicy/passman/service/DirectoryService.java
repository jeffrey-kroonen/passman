package nl.agilicy.passman.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import nl.agilicy.passman.dao.DirectoryDao;
import nl.agilicy.passman.model.Directory;

@Service
public class DirectoryService {
    
    private final DirectoryDao directoryDao;

    @Autowired
    public DirectoryService(@Qualifier("testDirectoryDao") DirectoryDao directoryDao) {
        this.directoryDao = directoryDao;
    }

    public boolean createDirectory(Directory directory) {
        return this.directoryDao.createDirectory(directory);
    }

    public List<Directory> getDirectories() {
        return this.directoryDao.getDirectories();
    }

    public Optional<Directory> getDirectoryById(UUID id) {
        return this.directoryDao.getDirectoryById(id);
    }

    public boolean updateDirectory(UUID id, Directory directory) {
        return this.directoryDao.updateDirectory(id, directory);
    }

    public boolean deleteDirectory(UUID id) {
        return this.directoryDao.deleteDirectory(id);
    }
}