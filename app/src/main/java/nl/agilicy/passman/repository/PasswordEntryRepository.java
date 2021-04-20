package nl.agilicy.passman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.agilicy.passman.model.PasswordEntry;

public interface PasswordEntryRepository extends JpaRepository<PasswordEntry, Long> {
    
    public PasswordEntry findTopByOrderByIdDesc();
}
