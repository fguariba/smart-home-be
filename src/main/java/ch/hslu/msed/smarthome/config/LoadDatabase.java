package ch.hslu.msed.smarthome.config;

import ch.hslu.msed.smarthome.model.User;
import ch.hslu.msed.smarthome.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            log.info("Preloading: "+ userRepository.save(new User("Francisco", "franciscoguariba@hotmail.com")));
            log.info("Preloading: "+ userRepository.save(new User("Uxia", "uxiarivero@gmail.com")));
        };
    }
}
