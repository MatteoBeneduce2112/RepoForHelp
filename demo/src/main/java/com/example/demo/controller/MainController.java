package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

    @Autowired
    UserService userServ;

    @GetMapping("/help")
    public String index() {
        return "index"; // Restituisce il template index.html
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Assicurati che ci sia un file login.html
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        userServ.registerUser(user);
        return "redirect:/login"; // Reindirizza alla pagina di login dopo la registrazione
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/homeUser")
    public String homeUser(){
        return "homeForUser";
    }
}