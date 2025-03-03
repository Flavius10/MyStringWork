package beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Person {

    private String name = "Flavius";
    private final Parrot parrot;

    public Person (@Qualifier ("parrot2") Parrot parrot){
        this.parrot = parrot;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Parrot getParrot(){
        return parrot;
    }
}
