package ch.hslu.msed.smarthome.config;

import ch.hslu.msed.smarthome.model.Home;
import ch.hslu.msed.smarthome.model.User;
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
            log.info("Preloading users:");
            log.info("user 1: "+ userRepo.save(new User("Francisco", "franciscoguariba@hotmail.com")));
            log.info("user 2: "+ userRepo.save(new User("Uxia", "uxiarivero@gmail.com")));

            log.info("Preloading homes:");
            log.info("home 1: "+ homeRepo.save(new Home()));
        };
    }
}
