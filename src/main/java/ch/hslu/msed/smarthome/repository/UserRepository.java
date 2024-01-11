package ch.hslu.msed.smarthome.repository;

import ch.hslu.msed.smarthome.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
