package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepo;

    @Autowired
    UserRepository userRepo;


    public String checkLoginAdmin(Admin admin) {
        admin.setEmailAdmin(admin.getEmailAdmin());
        admin.setPasswordAdmin(admin.getPasswordAdmin());

        String email = admin.getEmailAdmin();
        String domain = "@adminhelp.it";

        // Controllo email
        if (email.contains("@") && email.substring(email.indexOf("@")).equals(domain)) {
            adminRepo.save(admin);
            return "/dashboard";  // AdminHome
        }
        return "redirect:/help";  // reindirizzamento alla home iniziale
    }

    public String deleteUser(User user){
         userRepo.delete(user);
         return "/AdminHome";
    }
}