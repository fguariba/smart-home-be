package ch.hslu.msed.smarthome.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UUID id) {
        super("Could not find user with id: " + id);
    }
}
