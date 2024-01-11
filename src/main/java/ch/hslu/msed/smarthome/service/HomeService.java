package ch.hslu.msed.smarthome.service;

import ch.hslu.msed.smarthome.model.Home;
import ch.hslu.msed.smarthome.repository.HomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    private final HomeRepository homeRepository;

    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public List<Home> getAll() {
        return homeRepository.findAll();
    }
}
