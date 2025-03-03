package config;

import beans.Person;
import beans.Parrot;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot1(){
        var p = new Parrot();
        p.setName("Kiki");
        return p;
    }

    @Bean
    public Parrot parrot2(){
        var p = new Parrot();
        p.setName("Miki");
        return p;
    }

//    @Bean
//    @Primary
//    public Person person(Parrot parrot1){
//        var person = new Person();
//        person.setName("Flavius");
//        person.setParrot(parrot1);
//        return person;
//    }

    @Bean
    public Person person(Parrot parrot1){
        var person = new Person();
        person.setName("Luca");
        person.setParrot(parrot1);
        return person;
    }
}
