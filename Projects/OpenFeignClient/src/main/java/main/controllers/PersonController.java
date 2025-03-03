package main.controllers;

import main.models.Person;
import main.proxy.PersonProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PersonController {

    private final PersonProxy personProxy;

    public PersonController(PersonProxy personProxy){
        this.personProxy = personProxy;
    }

    @PostMapping("/person")
    public Person getPerson(
            @RequestBody Person person
    ){
        String requestID = UUID.randomUUID().toString();
        return personProxy.getPerson(requestID, person);
    }

}
