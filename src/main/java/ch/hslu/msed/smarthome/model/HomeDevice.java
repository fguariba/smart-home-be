package ch.hslu.msed.smarthome.model;

import java.time.LocalDate;
import java.util.UUID;

public abstract class HomeDevice {
    UUID id;

    String name;

    String state;

    LocalDate lastChange;

    LocalDate createdAt;
}
