package ch.hslu.msed.smarthome.model;

import java.util.List;
import java.util.UUID;

public class Home {
    UUID id;

    String kind;

    List<HomeDevice> devices;
}
