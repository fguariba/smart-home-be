package ch.hslu.msed.smarthome.service;

import ch.hslu.msed.smarthome.model.Device;
import ch.hslu.msed.smarthome.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAll() {
        return deviceRepository.findAll();
    }
}
