package ch.hslu.msed.smarthome.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public abstract class Device {
    @Id
    @UuidGenerator
    private UUID id;

    @NotNull
    private String name;

    private DeviceState state;

    @LastModifiedDate
    private LocalDate lastChange;

    @CreatedDate
    private LocalDate createdAt;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="home_id", nullable = false)
    private Home home;
}
