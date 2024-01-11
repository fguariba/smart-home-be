package ch.hslu.msed.smarthome.controller;

import ch.hslu.msed.smarthome.model.User;
import ch.hslu.msed.smarthome.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        return userService.add(user);
    }

    // Single item
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable String id) {
        return userService.replace(newUser, id);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable String id) {
        userService.deleteById(id);
    }
}
