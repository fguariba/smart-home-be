package ch.hslu.msed.smarthome.config;

import ch.hslu.msed.smarthome.model.Home;
import ch.hslu.msed.smarthome.model.User;
import ch.hslu.msed.smarthome.model.devices.DoorLight;
import ch.hslu.msed.smarthome.model.devices.WaterIrrigator;
import ch.hslu.msed.smarthome.model.devices.WindowBlinders;
import ch.hslu.msed.smarthome.repository.DeviceRepository;
import ch.hslu.msed.smarthome.repository.HomeRepository;
import ch.hslu.msed.smarthome.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepo, HomeRepository homeRepo, DeviceRepository deviceRepo) {
        return args -> {
            log.info("Preloading users...");
            final var francisco = new User("Francisco", "franciscoguariba@hotmail.com");
            final var uxia = new User("Uxia", "uxiarivero@gmail.com");
            log.info("user Francisco: "+ userRepo.save(francisco));
            log.info("user Uxia: "+ userRepo.save(uxia));

            log.info("Preloading homes...");
            final var franciscoHouse = new Home(francisco);
            final var uxiaHouse = new Home(uxia);
            log.info("Francisco's home: "+ homeRepo.save(franciscoHouse));
            log.info("Uxia's home: "+ homeRepo.save(uxiaHouse));

            log.info("Preloading devices...");
            final var waterIrrigator = new WaterIrrigator(franciscoHouse);
            final var doorLight = new DoorLight(franciscoHouse);
            final var windowBlinders = new WindowBlinders(franciscoHouse);
            log.info("Francisco's water irrigator: "+ deviceRepo.save(waterIrrigator));
            log.info("Francisco's door light: "+ deviceRepo.save(doorLight));
            log.info("Francisco's window blinders: "+ deviceRepo.save(windowBlinders));
        };
    }
}
