package main.models;

import org.apache.logging.log4j.util.Strings;

public class Person {

    private String name;
    private String id;

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
