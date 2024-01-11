package ch.hslu.msed.smarthome.controller;

import ch.hslu.msed.smarthome.model.Home;
import ch.hslu.msed.smarthome.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/homes")
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping
    public List<Home> getAll() {
        return homeService.getAll();
    }
}
