package ch.hslu.msed.smarthome.service;

import ch.hslu.msed.smarthome.service.model.WeatherDataResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {
    //private final WebClient weatherExtractorWebClient;

    public WeatherService(WebClient weatherExtractorWebClient) {
        //this.weatherExtractorWebClient = weatherExtractorWebClient;
    }

    @Value("${weather.extractor.endpoint}")
    private String weatherExtractorUrl;

    public WebClient weatherExtractorWebClient() {
        return WebClient.builder().baseUrl(weatherExtractorUrl).build();
    }

    public WeatherDataResponse getCurrentWeather(double latitude, double longitude) {
        return  WebClient.builder().build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host("localhost")
                        .port("8081")
                        .path("weather-info/open-meteo")
                        .queryParam("latitude", latitude)
                        .queryParam("longitude", longitude)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(WeatherDataResponse.class)
                .block();
    }
}