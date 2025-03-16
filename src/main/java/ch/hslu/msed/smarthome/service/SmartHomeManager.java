package ch.hslu.msed.smarthome.service;

import ch.hslu.msed.smarthome.service.model.SmartHomeResponseData;
import ch.hslu.msed.smarthome.service.model.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

@Component
@Slf4j
public class SmartHomeManager {

    public SmartHomeResponseData manageHomeDevices(WeatherResponse weatherResponse) {
        final var current = weatherResponse.getCurrent();
        final var daily = weatherResponse.getDaily();

        final List<Object> sunriseDays = daily.get("sunrise");
        final List<Object> sunsetDays = daily.get("sunset");
        final List<Object> precipitationProbabilities = daily.get("precipitation_probability_max");

        final var time = LocalDateTime.parse(current.get("time").toString(), ISO_DATE_TIME);
        final var temperature = (double) current.get("temperature_2m");
        final var sunrise = LocalDateTime.parse(sunriseDays.getFirst().toString(), ISO_DATE_TIME);
        final var sunset = LocalDateTime.parse(sunsetDays.getFirst().toString(), ISO_DATE_TIME);
        final var precipitationProbabilityMax = (int) precipitationProbabilities.getFirst();

        final var response = new SmartHomeResponseData();
        response.setLightsOn(turnOnLights(time, sunset, sunrise));
        response.setBlindersDown(closeWindowBlinds(time, temperature));
        response.setWaterPlants(waterPlants(precipitationProbabilityMax));
        return response;
    }

    private boolean turnOnLights(LocalDateTime time, LocalDateTime sunset, LocalDateTime sunrise) {
        final var midnight = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.MIDNIGHT);
        if (time.isAfter(sunset) && time.isBefore(midnight)) {
            log.info("turn on the lights in the evening");
            return true;
        }

        if (time.isAfter(sunrise) && time.isBefore(sunrise.plusMinutes(30))) {
            log.info("turn on the lights for 30min after sunrise");
            return true;
        }

        log.info("lights will not be turned on");
        return false;
    }

    private boolean closeWindowBlinds(LocalDateTime time, double temperature) {
        final var today = LocalDate.now();

        final var tenOClock = LocalTime.of(22, 0);
        final var todayTenOClock = LocalDateTime.of(today, tenOClock);

        final var sevenOClock = LocalTime.of(7, 0);
        final var todaySevenOClock = LocalDateTime.of(today, sevenOClock);

        if (time.isAfter(todayTenOClock) || time.isBefore(todaySevenOClock)) {
            return true;
        }
        if (temperature > 30) {
            log.info("close window blinds, because it is too hot");
            return true;
        }
        return false;
    }

    private boolean waterPlants(double rainProbability) {
        // TODO: improve validation
        if (rainProbability < 70) {
            log.info("water plants");
            return true;
        }
        log.info("plants will not be watered");
        return false;
    }
}
