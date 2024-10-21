package com.example.demo.service;


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
        user.setPassword(user.getPassword());

        if (userRepo.existsByEmail(user.getEmail())) {
            System.out.println("Utente già esistente: " + user.getEmail());
        } else {
            userRepo.save(user);
        }
    }
}