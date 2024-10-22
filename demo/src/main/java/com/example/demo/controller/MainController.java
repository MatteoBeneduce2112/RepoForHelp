package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class MainController {

    @Autowired
    UserService userServ;


    @GetMapping("/help")
    public String index() {
        return "index";
    }

    @GetMapping("/login2")
    public String showLoginForm() {
        return "login2";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        userServ.registerUser(user);
        return "redirect:/login2"; // Reindirizza alla pagina di login dopo la registrazione
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/homeForUser")
    public String login(User user, Long id) {
        return userServ.checkLogin(user, id);
    }
}