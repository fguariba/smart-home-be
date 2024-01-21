package ch.hslu.msed.smarthome.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_id", referencedColumnName = "id")
    @JsonManagedReference
    private Home home;

    public User() {}

    public User(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }
}
