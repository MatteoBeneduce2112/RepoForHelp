package com.example.demo.service;

import com.example.demo.model.DenunciaEdile;
import com.example.demo.model.DenunciaPolizia;
import com.example.demo.model.User;
import com.example.demo.repository.DenunciaEdileRepository;
import com.example.demo.repository.DenunciaPoliziaRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class DenunciaPoliziaService {


    @Autowired
    DenunciaPoliziaRepository denunciaPoliziaRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DenunciaEdileRepository denunciaEdileRepository;


    public List<String> getImages(User user) {
        user = userRepository.getIdByNameAndEmail(user.getName(), user.getEmail());
        List<String> imagesBase64 = new ArrayList<>();

        if (user != null) {
            try {
                DenunciaPolizia denunciaPolizia = denunciaPoliziaRepository.findImageByUserId(user);
                DenunciaEdile denunciaEdile = denunciaEdileRepository.findImageByUser(user);
                if (denunciaPolizia != null && denunciaPolizia.getImmaginePolizia() != null) {
                    String imageP = Base64.getEncoder().encodeToString(denunciaPolizia.getImmaginePolizia());
                    imagesBase64.add(imageP);
                    System.out.println("Url dell'immagine di polizia in base 64: " + imageP);
                }

                if (denunciaEdile != null && denunciaEdile.getImmagineEdile() != null) {
                    String imageE = Base64.getEncoder().encodeToString(denunciaEdile.getImmagineEdile());
                    imagesBase64.add(imageE);
                    System.out.println("Url dell'immagine edilizia in base 64: " + imageE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Utente non trovato");
        }
        System.out.println(imagesBase64);

        return imagesBase64;
    }

}