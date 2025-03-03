package main.controllers;

import main.models.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/romania")
    public Country romania(){
        Country country = Country.of("Romania", 23);
        return country;
    }

    @GetMapping("/all")
    public List<Country> all(){
        Country c1 = Country.of("Spain", 40);
        Country c2 = Country.of("Russia", 140);

        return List.of(c1, c2);
    }

}