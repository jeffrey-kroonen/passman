package nl.agilicy.passman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.agilicy.passman.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    //
}
