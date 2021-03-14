package nl.agilicy.passman.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import nl.agilicy.passman.model.User;

/**
 * UserDataAccessService
 */
@Repository("testUserDao")
public class UserDataAccessService implements UserDao {

    private static List<User> DB = new ArrayList<User>();

    @Override
    public boolean createUser(User user) {
        DB.add(user);
        return true;
    }
    
    @Override
    public List<User> getUsers() {
        return DB;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return DB.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public boolean updateUser(Long id, User userToUpdate) {
        return getUserById(id)
            .map(user -> {
                int indexOfUserToUpdate = DB.indexOf(user);
                if (indexOfUserToUpdate >= 0) {
                    DB.set(indexOfUserToUpdate, userToUpdate);
                    return true;
                }
                return false;
            }).orElse(false);
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> user = getUserById(id);

        if (!user.isEmpty()) {
            DB.remove(user.get());
            return true;
        }

        return false;
    }
}