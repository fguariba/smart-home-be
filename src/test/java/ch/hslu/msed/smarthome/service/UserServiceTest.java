package ch.hslu.msed.smarthome.service;

import ch.hslu.msed.smarthome.model.Home;
import ch.hslu.msed.smarthome.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    @Test
    void serializeUserWithHome_successfully() throws JsonProcessingException {
        // arrange
        final var user = new User("Francisco", "franciscoguariba@hotmail.com");
        final var home = new Home(user);
        user.setHome(home);

        // act
        final var jsonValue = new ObjectMapper().writeValueAsString(home);

        // assert
        assertEquals(
                "{\"id\":null,\"type\":null,\"devices\":null,\"postalCode\":null,\"city\":null,\"country\":null,\"latitude\":0.0,\"longitude\":0.0}",
                jsonValue);
    }
}
