package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Flavius";

    private final Parrot parrot;

    @Autowired
    public Person(Parrot parrot){
        this.parrot = parrot;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String setParrot(){
        return "Parrot : " + parrot.getName();
    }

}
