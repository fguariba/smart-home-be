package ch.hslu.msed.smarthome.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SmartHomeResponseData {
    @JsonProperty("lights_on")
    private boolean lightsOn;
    @JsonProperty("blinders_down")
    private boolean blindersDown;
    @JsonProperty("water_plants")
    private boolean waterPlants;
}
