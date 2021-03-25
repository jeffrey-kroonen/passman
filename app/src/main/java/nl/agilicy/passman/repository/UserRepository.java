 package nl.agilicy.passman.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.agilicy.passman.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    public Optional<User> findByEmail(String username);
}
