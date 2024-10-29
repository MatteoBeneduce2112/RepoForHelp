package com.example.demo.service;

import com.example.demo.model.DenunciaPolizia;
import com.example.demo.model.User;
import com.example.demo.repository.DenunciaPoliziaRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class DenunciaPoliziaService {


    @Autowired
    DenunciaPoliziaRepository denunciaPoliziaRepository;

    @Autowired
    UserRepository userRepository;


    public String imagePolice(User user){
        user = userRepository.getIdByNameAndEmail(user.getName(), user.getEmail());
        if(user!= null){
            System.out.println("Utente con id uguale ad :" +user.getId());
        }

        return "imageSearch";
    }
}
