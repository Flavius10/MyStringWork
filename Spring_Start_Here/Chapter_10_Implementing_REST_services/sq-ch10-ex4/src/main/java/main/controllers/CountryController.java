package main.controllers;

import main.models.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/romania")
    public ResponseEntity<Country> romania(){
        Country c = Country.of("Romania", 23);
        return ResponseEntity.status(HttpStatus.ACCEPTED).
                header("continent", "Europa").
                header("capital", "Bucuresti").
                header("skills", "all of them")
                .body(c);
    }

}