package ch.hslu.msed.smarthome.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class WeatherResponse {
    private double latitude;
    private double longitude;
    @JsonProperty("generationtime_ms")
    private double generationTimeMS;
    @JsonProperty("utc_offset_seconds")
    private int utcOffsetSeconds;
    private String timezone;
    @JsonProperty("timezone_abbreviation")
    private String timezoneAbbreviation;
    private double elevation;
    @JsonProperty("current_units")
    private Map<String, String> currentUnits;
    private Map<String, Object> current;
    @JsonProperty("daily_units")
    private Map<String, String> dailyUnits;
    private Map<String, Object> daily;
}
