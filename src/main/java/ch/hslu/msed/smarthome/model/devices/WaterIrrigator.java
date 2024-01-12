package ch.hslu.msed.smarthome.model.devices;

import ch.hslu.msed.smarthome.model.Device;
import ch.hslu.msed.smarthome.model.Home;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("WATER_IRRIGATOR")
@Setter
@Getter
@ToString
public final class WaterIrrigator extends Device {
    private double waterQuantity;

    public WaterIrrigator(Home home) {
        super.setHome(home);
    }

    public WaterIrrigator() {}

    public void waterPlants() {
        // TODO: add logic
    }

    public void supplyWater() {
        // TODO: add logic
    }
}
