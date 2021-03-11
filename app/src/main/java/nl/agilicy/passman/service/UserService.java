package nl.agilicy.passman.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import nl.agilicy.passman.dao.UserDao;
import nl.agilicy.passman.model.User;

@Service
public class UserService {
    
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("testUserDao") UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean createUser(User user) {
        return this.userDao.createUser(user);
    }

    public List<User> getUsers() {
        return this.userDao.getUsers();
    }

    public Optional<User> getUserById(UUID id) {
        return this.userDao.getUserById(id);
    }

    public boolean updateUser(UUID id, User user) {
        return this.userDao.updateUser(id, user);
    }

    public boolean deleteUser(UUID id) {
        return this.userDao.deleteUser(id);
    }
}