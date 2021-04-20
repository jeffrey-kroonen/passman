package nl.agilicy.passman.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.agilicy.passman.model.User;
import nl.agilicy.passman.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        this.userRepository.save(user);
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return this.userRepository.findById(id);
    }

    public User getlast() {
        return this.userRepository.findTopByOrderByIdDesc();
    }

    public boolean updateUser(Long id, User userToUpdate) {
        User user = this.getUserById(id).orElse(null);

        if (Objects.isNull(user)) {
            return false;
        }

        user.setFirst_name(userToUpdate.getFirst_name());
        user.setLast_name(userToUpdate.getLast_name());
        user.setEmail(userToUpdate.getEmail());
        user.setIs_active(userToUpdate.isIs_active());
        user.setIs_verified(userToUpdate.isIs_verified());

        this.userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long id) {
        User user = this.getUserById(id).orElse(null);

        if (Objects.isNull(user)) {
            return false;
        }

        this.userRepository.delete(user);
        return true;
    }
}
