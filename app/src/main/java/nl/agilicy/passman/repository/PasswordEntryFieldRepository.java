package nl.agilicy.passman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.agilicy.passman.model.PasswordEntryField;

public interface PasswordEntryFieldRepository extends JpaRepository<PasswordEntryField, Long> {
    //
}
