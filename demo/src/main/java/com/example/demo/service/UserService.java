package com.example.demo.service;

import com.example.demo.model.DenunciaEdile;
import org.springframework.ui.Model;
import com.example.demo.model.DenunciaPolizia;
import com.example.demo.model.User;
import com.example.demo.repository.DenunciaPoliziaRepository;
import com.example.demo.repository.DenunciaEdileRepository;
import com.example.demo.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    DenunciaPoliziaRepository denPoRepo;

    @Autowired
    DenunciaEdileRepository denEdRepo;

    public void registerUser(User user) {

        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setEmail(user.getEmail());
        user.setUsername(user.getUsername());

        String encodedPassword = hashPassword(user.getPassword());
        user.setPassword(encodedPassword);


        if (userRepo.existsByEmail(user.getEmail())) {
            System.out.println("Utente già esistente: " + user.getEmail());
        } else {
            userRepo.save(user);
        }
    }

    // Metodo per criptare la password
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String checkLogin(User user, HttpSession session , Model model) {
        // Ricerca utente tramite lo username
        User storedUser = userRepo.findByUsername(user.getUsername());
        if (storedUser != null) {
            System.out.println("Utente trovato: " + storedUser);
            // Controllo password
            if (BCrypt.checkpw(user.getPassword(), storedUser.getPassword())) {
                session.setAttribute("user", user);
                // Timeout della sessione a 30 minuti
                session.setMaxInactiveInterval(30 * 60);
                return "/homeForUser"; // Login riuscito
            }else{
                System.out.println("Password non corretta: " + user.getPassword());
            }
        } else {
            System.out.println("Nessun utente trovato con username: " + user.getUsername());
        }
        return "/login2"; // Login fallito
    }

    public void saveDenunciaPolizia(String positionPolizia, String descriptionPolizia, MultipartFile file) throws IOException {
        DenunciaPolizia denuncia = new DenunciaPolizia();
        denuncia.setPositionPolizia(positionPolizia);
        denuncia.setDescriptionPolizia(descriptionPolizia);
        denuncia.setImmaginePolizia(file.getBytes());

        // Salva la denuncia nel database
        denPoRepo.save(denuncia);
    }

    public void saveDenunciaEdilizia(String positionEdile, String descriptionEdile, MultipartFile file) throws IOException {
        DenunciaEdile denuncia = new DenunciaEdile();
        denuncia.setPositionEdile(positionEdile);
        denuncia.setDescriptionEdile(descriptionEdile);
        denuncia.setImmagineEdile(file.getBytes());

        // Salva la denuncia nel database
        denEdRepo.save(denuncia);

    }
}