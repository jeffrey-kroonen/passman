package nl.agilicy.passman.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.agilicy.passman.repository.DirectoryRepository;
import nl.agilicy.passman.model.Directory;

@Service
public class DirectoryService {
    
    private final DirectoryRepository directoryRepository;

    @Autowired
    public DirectoryService(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    public void createDirectory(Directory directory) {
        this.directoryRepository.save(directory);
    }

    public List<Directory> getDirectories() {
        return this.directoryRepository.findAll();
    }

    public Optional<Directory> getDirectoryById(Long id) {
        return this.directoryRepository.findById(id);
    }

    public boolean updateDirectory(Long id, Directory directoryToUpdate) {
        Directory directory = this.getDirectoryById(id).orElse(null);

        if (Objects.isNull(directory)) {
            return false;
        }

        directory.setName(directoryToUpdate.getName());
        directory.setIs_active(directoryToUpdate.isIs_active());

        this.directoryRepository.save(directory);
        return true;
    }

    public boolean deleteDirectory(Long id) {
        Directory directory = this.getDirectoryById(id).orElse(null);

        if (Objects.isNull(directory)) {
            return false;
        }

        this.directoryRepository.delete(directory);
        return true;
    }
}