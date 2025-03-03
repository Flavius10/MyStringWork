package beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Person {

    private String name = "Flavius";
    private final Parrot parrot;

    public Person (Parrot parrot2){
        this.parrot = parrot2;
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
