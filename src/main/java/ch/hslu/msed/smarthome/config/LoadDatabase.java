package ch.hslu.msed.smarthome.config;

import ch.hslu.msed.smarthome.model.Device;
import ch.hslu.msed.smarthome.model.Home;
import ch.hslu.msed.smarthome.model.User;
import ch.hslu.msed.smarthome.model.devices.DoorLight;
import ch.hslu.msed.smarthome.model.devices.IrrigationSystem;
import ch.hslu.msed.smarthome.model.devices.WindowBlinders;
import ch.hslu.msed.smarthome.repository.DeviceRepository;
import ch.hslu.msed.smarthome.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepo, DeviceRepository deviceRepo) {
        return args -> {
            log.info("Preloading users and homes...");
            final var franciscoHouse = new Home(52.52, 13.41);
            final var francisco = new User("Francisco", "franciscoguariba@hotmail.com", franciscoHouse);
            log.info("user Francisco: "+ userRepo.save(francisco));

            final var uxiaHouse = new Home(42.52, 16.42);
            final var uxia = new User("Uxia", "uxiarivero@gmail.com", uxiaHouse);
            log.info("user Uxia: "+ userRepo.save(uxia));

            log.info("Preloading devices...");
            final Device irrigationSystem = new IrrigationSystem(franciscoHouse);
            final Device doorLight = new DoorLight(franciscoHouse);
            final Device windowBlinders = new WindowBlinders(franciscoHouse);
            log.info("Francisco's irrigation system: "+ deviceRepo.save(irrigationSystem));
            log.info("Francisco's door light: "+ deviceRepo.save(doorLight));
            log.info("Francisco's window blinders: "+ deviceRepo.save(windowBlinders));

            final Device irrigationSystem2 = new IrrigationSystem(uxiaHouse);
            final Device doorLight2 = new DoorLight(uxiaHouse);
            final Device windowBlinders2 = new WindowBlinders(uxiaHouse);
            log.info("Uxia's irrigation system: "+ deviceRepo.save(irrigationSystem2));
            log.info("Uxia's door light: "+ deviceRepo.save(doorLight2));
            log.info("Uxia's window blinders: "+ deviceRepo.save(windowBlinders2));
        };
    }
}
