package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="denunciaPolizia")
public class DenunciaPolizia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_DenunciaPolizia ;

    @Lob
    @Column(name = "immagine_polizia", columnDefinition = "LONGBLOB")
    private byte[] immaginePolizia;

    @Column(name = "descriptionPolizia")
    private String descriptionPolizia;

    @Column(name = "positionPolizia")
    private String positionPolizia;

    @ManyToOne
    private User userId;

    public DenunciaPolizia() {
    }

    public DenunciaPolizia(Long id_DenunciaPolizia, byte[] immaginePolizia, String descriptionPolizia, String positionPolizia, User userId) {
        this.id_DenunciaPolizia = id_DenunciaPolizia;
        this.immaginePolizia = immaginePolizia;
        this.descriptionPolizia = descriptionPolizia;
        this.positionPolizia = positionPolizia;
        this.userId = userId;
    }

    public Long getId_DenunciaPolizia() {
        return id_DenunciaPolizia;
    }

    public void setId_DenunciaPolizia(Long id_DenunciaPolizia) {
        this.id_DenunciaPolizia = id_DenunciaPolizia;
    }

    public byte[] getImmaginePolizia() {
        return immaginePolizia;
    }

    public void setImmaginePolizia(byte[] immaginePolizia) {
        this.immaginePolizia = immaginePolizia;
    }

    public String getDescriptionPolizia() {
        return descriptionPolizia;
    }

    public void setDescriptionPolizia(String descriptionPolizia) {
        this.descriptionPolizia = descriptionPolizia;
    }

    public String getPositionPolizia() {
        return positionPolizia;
    }

    public void setPositionPolizia(String positionPolizia) {
        this.positionPolizia = positionPolizia;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}