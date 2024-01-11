package ch.hslu.msed.smarthome.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private HomeType type;

    @JsonManagedReference
    @OneToMany(mappedBy = "home")
    private Set<Device> devices;

    private String city;

    private String state;

    private String country;

    private String street;
}
