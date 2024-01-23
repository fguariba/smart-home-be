package ch.hslu.msed.smarthome.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Home {
    @Id
    @UuidGenerator
    private UUID id;

    @OneToOne(mappedBy = "home")
    @JsonBackReference
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "home")
    private Set<Device> devices;

    private String postalCode;

    private String city;

    private String country;

    private double latitude;

    private double longitude;

    public Home() {}

    public Home(User user) {
        this.user = user;
    }

    public Home(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Home(double latitude, double longitude, User user) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.user = user;
    }
}
