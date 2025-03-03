package main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("username", "Flavius");
        model.addAttribute("color", "red");
        return "home.html";
    }

}
