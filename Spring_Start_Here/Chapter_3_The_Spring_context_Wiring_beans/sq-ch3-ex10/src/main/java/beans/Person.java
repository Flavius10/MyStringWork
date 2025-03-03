package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Flavius";

    private Parrot parrot;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Autowired
    public void setParrot(Parrot parrot){
        this.parrot = parrot;
    }

    public String getParrot(){
        return "Parrot : " + parrot.getName();
    }
}
