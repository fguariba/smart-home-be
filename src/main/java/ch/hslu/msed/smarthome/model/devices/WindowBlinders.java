package ch.hslu.msed.smarthome.model.devices;

import ch.hslu.msed.smarthome.model.Device;
import ch.hslu.msed.smarthome.model.Home;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("WINDOW_BLINDERS")
@Getter
@Setter
@ToString
public class WindowBlinders extends Device {
    private int angle;

    public WindowBlinders(Home home) {
        super(home);
    }

    public WindowBlinders() {}

    public void open() {
        // TODO: add logic
    }

    public void close() {
        // TODO: add logic
    }
}
