package ch.hslu.msed.smarthome.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${weather.extractor.endpoint}")
    private String weatherExtractorUrl;

    @Bean
    public WebClient weatherExtractorWebClient() {
        return WebClient.builder().baseUrl(weatherExtractorUrl).build();
    }
}
