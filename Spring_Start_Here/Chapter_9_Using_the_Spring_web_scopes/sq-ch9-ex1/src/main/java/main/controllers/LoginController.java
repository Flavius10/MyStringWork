package main.controllers;

import main.models.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;

    @Autowired
    LoginController(LoginProcessor loginProcessor){
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet(){
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model){

        loginProcessor.setPassword(password);
        loginProcessor.setUsername(username);

        boolean loginOk = loginProcessor.login();

        if(loginOk)
            model.addAttribute("message", "You are successfully log in!");
        else
            model.addAttribute("message", "Login failed");

        return "login.html";
    }


}
