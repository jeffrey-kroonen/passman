package nl.agilicy.passman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.agilicy.passman.model.Directory;

public interface DirectoryRepository extends JpaRepository<Directory, Long> {
    //
}
