package ch.hslu.msed.smarthome.service;

import ch.hslu.msed.smarthome.exception.UserNotFoundException;
import ch.hslu.msed.smarthome.model.User;
import ch.hslu.msed.smarthome.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    public User findById(String id) {
        final UUID uuid = UUID.fromString(id);
        return userRepository.findById(uuid)
                .orElseThrow(() -> new UserNotFoundException(uuid));
    }

    public User replace(User newUser, String id) {
        final UUID uuid = UUID.fromString(id);
        return userRepository.findById(uuid)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException(uuid));
    }

    public void deleteById(String id) {
        final UUID uuid = UUID.fromString(id);
        userRepository.deleteById(uuid);
    }

    private void provideAddress() {
        // TODO: add logic
    }

    private void changeAddress() {
        // TODO: add logic
    }
}
