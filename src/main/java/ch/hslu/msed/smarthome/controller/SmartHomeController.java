package ch.hslu.msed.smarthome.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmartHomeController {

    @GetMapping("/weather-info")
    public String getWeatherInfo() {
        return "Hello";
    }
}
