package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Flavius";

    @Autowired
    private Parrot parrot;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getParrot() {
        return "Parrot : " + parrot.getName();
    }

}
