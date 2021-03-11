package nl.agilicy.passman.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import nl.agilicy.passman.model.User;

/**
 * UserDataAccessService
 */
public interface UserDao {

    boolean createUser(User user);
    
    List<User> getUsers();

    Optional<User> getUserById(UUID id);

    boolean updateUser(UUID id, User user);

    boolean deleteUser(UUID id);
}