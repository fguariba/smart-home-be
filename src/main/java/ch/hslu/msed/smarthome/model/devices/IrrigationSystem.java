package ch.hslu.msed.smarthome.model.devices;

import ch.hslu.msed.smarthome.model.Device;
import ch.hslu.msed.smarthome.model.Home;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("IRRIGATION_SYST")
@Setter
@Getter
@ToString
public final class IrrigationSystem extends Device {
    private double waterQuantity;

    public IrrigationSystem(Home home) {
        super(home);
    }

    public IrrigationSystem() {}

    public void waterPlants() {
        // TODO: add logic
    }

    public void supplyWater() {
        // TODO: add logic
    }
}
