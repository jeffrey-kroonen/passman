package nl.agilicy.passman.dao;

import java.util.List;
import java.util.Optional;

import nl.agilicy.passman.model.User;

/**
 * UserDao
 */
public interface UserDao {

    boolean createUser(User user);
    
    List<User> getUsers();

    Optional<User> getUserById(Long id);

    boolean updateUser(Long id, User user);

    boolean deleteUser(Long id);
}