package ch.hslu.msed.smarthome;

import ch.hslu.msed.smarthome.controller.DeviceController;
import ch.hslu.msed.smarthome.controller.HomeController;
import ch.hslu.msed.smarthome.controller.UserController;
import ch.hslu.msed.smarthome.controller.WeatherController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("it")
class SmartHomeApplicationTests {
    @Autowired
    DeviceController deviceController;
    @Autowired
    HomeController homeController;
    @Autowired
    UserController userController;
    @Autowired
    WeatherController weatherController;

    @Test
    void contextLoads() {
        assertNotNull(deviceController);
        assertNotNull(homeController);
        assertNotNull(userController);
        assertNotNull(weatherController);
    }
}
