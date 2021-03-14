package nl.agilicy.passman.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.agilicy.passman.model.User;
import nl.agilicy.passman.service.UserService;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        this.userService.createUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id).orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        this.userService.updateUser(id, user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);
    }

}
