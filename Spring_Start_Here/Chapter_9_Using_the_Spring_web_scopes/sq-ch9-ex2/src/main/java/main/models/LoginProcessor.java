package main.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;

    private String username;
    private String password;

    @Autowired
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService){
        this.loggedUserManagementService = loggedUserManagementService;
    }

    public boolean login(){
        String username = this.getUsername();
        String password = this.getPassword();

        boolean loginOk = false;

        if("Flavius".equals(username) && "password".equals(password))
        {
            loginOk = true;
            loggedUserManagementService.setUsername(username);
        }

        return loginOk;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }



}
