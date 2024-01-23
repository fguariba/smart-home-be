package ch.hslu.msed.smarthome.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmartHomeManagerServiceTest {
    @Test
    void convertISO8601ToDate_successfully() {
        // arrange
        final String time = "2024-01-23T10:00";

        // act
        final LocalDateTime convertedTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);

        // assert
        assertNotNull(convertedTime);
    }

    @Test
    void convertISO8601ToDate_throwsParseException() {
        // arrange
        final String time = "2024-01-23T10:0";

        // act & assert
        assertThrows(DateTimeParseException.class, () -> LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME));
    }
}
