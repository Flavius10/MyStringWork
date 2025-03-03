package config;

import beans.Parrot;
import beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Kiki");
        return p;
    }

    @Bean
    Person person(Parrot parrot){
        var person = new Person();
        person.setName("Flavius");
        person.setParrot(parrot);
        return person;
    }
}
