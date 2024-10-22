package com.example.demo.service;

import org.mindrot.jbcrypt.BCrypt;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String checkLogin(User user, Long id) {
        // Recupera l'utente dal database usando l'ID
        User storedUser = userRepo.findById(1L).orElse(null);

        // Controlla se l'utente esiste
        if (storedUser != null) {
            // Confronta la password fornita con quella memorizzata
            if (BCrypt.checkpw(user.getPassword(), storedUser.getPassword())) {
                return "homeForUser"; // Login riuscito
            }
        }
        return "Errore"; // Login fallito
    }

}