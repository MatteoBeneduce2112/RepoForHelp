package com.example.demo.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name="denuncia")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Denuncia ;


    @Column(name = "immagine")
    private List<String> immagine;

    @Column(name = "description")
    private String description;


    public Denuncia() {
    }

    public Denuncia(Long idDenuncia, List<String> immagine, String description) {
        this.id_Denuncia = idDenuncia;
        this.immagine = immagine;
        this.description = description;
    }

    public Long getIdDenuncia() {
        return id_Denuncia;
    }

    public void setIdDenuncia(Long idDenuncia) {
        this.id_Denuncia = idDenuncia;
    }

    public List<String> getImmagine() {
        return immagine;
    }

    public void setImmagine(List<String> immagine) {
        this.immagine = immagine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}