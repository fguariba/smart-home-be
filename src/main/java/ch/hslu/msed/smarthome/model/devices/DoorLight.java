package ch.hslu.msed.smarthome.model.devices;

import ch.hslu.msed.smarthome.model.Device;
import ch.hslu.msed.smarthome.model.Home;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("DOOR_LIGHT")
@Setter
@Getter
@ToString
public class DoorLight extends Device {

    public DoorLight(Home home) {
       super(home);
    }

    public DoorLight() {}

    public void turnOn() {
        // TODO: add logic
    }

    public void turnOff() {
        // TODO: add logic
    }
}
