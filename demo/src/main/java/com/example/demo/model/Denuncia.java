package com.example.demo.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name="denuncia")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id_Denuncia ;

    @Column(name = "immaginePolizia")
    private List<String> immaginePolizia;

    @Column(name = "descriptionPolizia")
    private String descriptionPolizia;

    @Column(name = "immagineEdile")
    private List<String> immagineEdile;

    @Column(name = "descriptionEdile")
    private String descriptionEdile;

    public Denuncia() {
    }

    public Denuncia(Long idDenuncia, List<String> immagine, String descriptionPolizia, List<String> immagineEdile, String descriptionEdile) {
        this.id_Denuncia = idDenuncia;
        this.immaginePolizia = immagine;
        this.descriptionPolizia = descriptionPolizia;
        this.immagineEdile = immagineEdile;
        this.descriptionEdile = descriptionEdile;
    }

    public Long getIdDenuncia() {
        return id_Denuncia;
    }

    public void setIdDenuncia(Long idDenuncia) {
        this.id_Denuncia = idDenuncia;
    }

    public List<String> getImmagine() {
        return immaginePolizia;
    }

    public void setImmagine(List<String> immagine) {
        this.immaginePolizia = immagine;
    }

    public String getDescriptionPolizia() {
        return descriptionPolizia;
    }

    public void setDescriptionPolizia(String descriptionPolizia) {
        this.descriptionPolizia = descriptionPolizia;
    }

    public List<String> getImmagineEdile() {
        return immagineEdile;
    }

    public void setImmagineEdile(List<String> immagineEdile) {
        this.immagineEdile = immagineEdile;
    }

    public String getDescriptionEdile() {
        return descriptionEdile;
    }

    public void setDescriptionEdile(String descriptionEdile) {
        this.descriptionEdile = descriptionEdile;
    }
}