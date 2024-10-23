package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


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
    public String login(User user, HttpSession session, Model model) {
        // Controlla le credenziali dell'utente
        String result = userServ.checkLogin(user);

        if (result!=null) {
            // Aggiungi l'utente alla sessione
            session.setAttribute("user", user);
            // Timeout della sessione a 30 minuti
            session.setMaxInactiveInterval(30 * 60);

            return "redirect:/homeForUser";
        } else {
            //Login Fallito
            model.addAttribute("error", "Credenziali errate");
            // Torna alla pagina di login
            return "login2";
        }
    }

    @GetMapping("/homeForUser")
    public String homeForUser(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        // Verifica se l'utente è presente nella sessione
        if (user == null) {
            model.addAttribute("error", "Sessione scaduta, effettua nuovamente il login.");
            return "login2"; // Reindirizza alla pagina di login
        }

        model.addAttribute("user", user);
        return "homeForUser"; // Mostra la pagina homeForUser
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidare la sessione
        return "redirect:/login2"; // Reindirizza alla pagina di login
    }


}