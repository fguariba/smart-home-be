package ch.hslu.msed.smarthome.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
public class User {
    @Id
    @UuidGenerator
    private UUID id;

    @NotNull
    private String firstName;

    private String lastName;

    @NotNull
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Home home;

    public User() {}

    public User(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }
}
