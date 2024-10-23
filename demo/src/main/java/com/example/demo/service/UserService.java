package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

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

    public String checkLogin(User user) {
        // Ricerca utente tramite lo username
        User storedUser = userRepo.findByUsername(user.getUsername());
        if (storedUser != null) {
            System.out.println("Utente trovato: " + storedUser);
            // Controllo password
            if (BCrypt.checkpw(user.getPassword(), storedUser.getPassword())) {
                return "homeForUser"; // Login riuscito
            }else{
                System.out.println("Password non corretta: " + user.getPassword());
            }
        } else {
            System.out.println("Nessun utente trovato con username: " + user.getUsername());
        }
        return "error"; // Login fallito
    }
}