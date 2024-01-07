package ch.hslu.msed.smarthome.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    public User() {}

    public User(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }

    private void provideAddress() {
        // TODO: add logic
    }

    private void changeAddress() {
        // TODO: add logic
    }
}
