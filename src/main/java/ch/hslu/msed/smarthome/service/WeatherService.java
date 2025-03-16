package ch.hslu.msed.smarthome.service;

import ch.hslu.msed.smarthome.service.model.SmartHomeResponseData;
import ch.hslu.msed.smarthome.service.model.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WeatherService {
    private final WebClient weatherExtractorWebClient;
    private final SmartHomeManager smartHomeManagerService;

    public WeatherService(WebClient weatherExtractorWebClient, SmartHomeManager smartHomeManagerService) {
        this.weatherExtractorWebClient = weatherExtractorWebClient;
        this.smartHomeManagerService = smartHomeManagerService;
    }

    public SmartHomeResponseData buildSmartHomeResponse(double latitude, double longitude) {
        final var currentWeather = getCurrentWeather(latitude, longitude);
        return smartHomeManagerService.manageHomeDevices(currentWeather);
    }

    public WeatherResponse getCurrentWeather(double latitude, double longitude) {
        log.info("get current weather...");
        return  weatherExtractorWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("weather-info/open-meteo")
                        .queryParam("latitude", latitude)
                        .queryParam("longitude", longitude)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();
    }
}
