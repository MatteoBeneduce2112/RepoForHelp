package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.model.DenunciaPolizia;
import com.example.demo.model.User;
import com.example.demo.repository.DenunciaEdileRepository;
import com.example.demo.repository.DenunciaPoliziaRepository;
import com.example.demo.service.AdminService;
import com.example.demo.service.DenunciaPoliziaService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userServ;
    @Autowired
    AdminService adminServ;
    @Autowired
    DenunciaEdileRepository denEdiRepo;
    @Autowired
    DenunciaPoliziaRepository denPoRepo;

    @Autowired
    DenunciaPoliziaService denunciaPoliziaService;


    @GetMapping("/help")
    public String index() {
        return "index";
    }

    @GetMapping("/LoginAdmin")
    public String loginAdmin() {
        return "LoginAdmin";
    }

    @PostMapping("/LoginAdmin")
    public String checkLogin(Admin admin) {
        return adminServ.checkLoginAdmin(admin);
    }

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        List<User> users = userServ.getAllUsers();
        model.addAttribute("users", users);
        return "dashboard";
    }

    @PostMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userServ.deleteUser(userId);
        return "redirect:/dashboard";  // Reindirizza alla dashboard dopo l'eliminazione
    }

    @GetMapping("/AdminHome")
    public String adminHome() {
        return "dashboard";
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
        return userServ.checkLogin(user, session, model);
    }

    @GetMapping("/homeForUser")
    public String homeForUser(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "Sessione scaduta, effettua nuovamente il login.");
            return "login2"; // Reindirizza alla pagina di login
        }
        model.addAttribute("user", user);
        return "homeForUser"; // Mostra la pagina homeForUser
    }

    @GetMapping("/insertImagePolice")
    public String insertImage() {
        return "insertImagePolizia";
    }

    @PostMapping("/insertImagePolice")
    public String insertInfoPolice(@RequestParam("positionPolizia") String positionPolizia, @RequestParam("descriptionPolizia") String descriptionPolizia, @RequestParam("immaginePolizia") MultipartFile file, Model model) {

        try {
            userServ.saveDenunciaPolizia(positionPolizia, descriptionPolizia, file);
            model.addAttribute("message", "Denuncia inviata con successo!");
        } catch (IOException e) {
            model.addAttribute("error", "Errore durante l'invio della denuncia: " + e.getMessage());
        }

        return "insertImagePolizia"; // Torna al modulo
    }

    @GetMapping("/insertImageEdil")
    public String insertImageEdil() {
        return "insertImageEdilizia";
    }

    @PostMapping("insertImageEdil")
    public String insertInfoEdilizia(@RequestParam("positionEdile") String positionEdile, @RequestParam("descriptionEdile") String descriptionEdile, @RequestParam("immagineEdile") MultipartFile file, Model model) {

        try {
            userServ.saveDenunciaEdilizia(positionEdile, descriptionEdile, file);
            model.addAttribute("message", "Denuncia inviata con successo!");
        } catch (IOException e) {
            model.addAttribute("error", "Errore durante l'invio della denuncia: " + e.getMessage());
        }

        return "insertImageEdilizia";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login2"; // Reindirizzamento pagina di login
    }

    @GetMapping("/imageSearch")
    public String imageSearch() {
        return "imageSearch";
    }

    @PostMapping("/imageSearch")
    public String searchImages(User user, Model model) {
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        List<String> images = new ArrayList<>();
        images = denunciaPoliziaService.getImages(user);
        model.addAttribute("images", images);
        return "imageResult";
    }
}