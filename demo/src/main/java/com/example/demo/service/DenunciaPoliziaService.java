package com.example.demo.service;

import com.example.demo.model.DenunciaEdile;
import com.example.demo.model.DenunciaPolizia;
import com.example.demo.model.User;
import com.example.demo.repository.DenunciaEdileRepository;
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

    @Autowired
    DenunciaEdileRepository denunciaEdileRepository;


    public String image(User user, Long id){
        user = userRepository.getIdByNameAndEmail(user.getName(), user.getEmail());
        if(user!= null){
            try{
            DenunciaPolizia denunciaPolizia = new DenunciaPolizia();
            DenunciaEdile denunciaEdile = new DenunciaEdile();
            denunciaPolizia = denunciaPoliziaRepository.findImageByUserId(user);
            denunciaEdile = denunciaEdileRepository.findImageByUser(user);
            System.out.println("Questa è la sua denuncia polizia : " +denunciaPolizia);
            System.out.println("Questa è la sua denuncia edile : " +denunciaEdile);
            System.out.println("Utente con id(polizia) uguale ad :" +user.getId());
            System.out.println("Utente con id(edile) uguale ad :" +user.getId());
            String imageP  = Base64.getEncoder().encodeToString(denunciaPolizia.getImmaginePolizia());
            String imageE  = Base64.getEncoder().encodeToString(denunciaEdile.getImmagineEdile());
            System.out.println("Url dell'immagine di polizia in base 64 : " +imageP);
            System.out.println("Url dell'immagine edilizia in base 64 : " +imageE);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        return "imageSearch";
    }
}
