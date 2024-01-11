package ch.hslu.msed.smarthome.repository;

import ch.hslu.msed.smarthome.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
