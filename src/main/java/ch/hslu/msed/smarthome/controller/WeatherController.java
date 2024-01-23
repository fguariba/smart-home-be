package ch.hslu.msed.smarthome.controller;

import ch.hslu.msed.smarthome.service.WeatherService;
import ch.hslu.msed.smarthome.service.model.SmartHomeResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/current-weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<SmartHomeResponseData> getCurrentWeather(@RequestParam double latitude, @RequestParam double longitude) {
        final var response = weatherService.buildSmartHomeResponse(latitude, longitude);
        return ResponseEntity.ok(response);
    }
}
