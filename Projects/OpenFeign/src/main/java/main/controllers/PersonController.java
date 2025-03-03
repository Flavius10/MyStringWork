package main.controllers;

import main.models.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PersonController {

    private static Logger logger = Logger.getLogger(PersonController.class.getName());

    @PostMapping("/person")
    public ResponseEntity<Person> createPayment(
            @RequestHeader String requestId,
            @RequestBody Person person
    ) {
        logger.info("Received request with ID " + requestId +
                " ;Person Name: " + person.getName());

        person.setId(UUID.randomUUID().toString());

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(person);
    }

}
