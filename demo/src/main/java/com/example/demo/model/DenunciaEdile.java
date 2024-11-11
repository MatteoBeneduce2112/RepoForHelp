package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="denunciaEdile")
public class DenunciaEdile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_DenunciaEdile;

    @Lob
    @Column(name = "immagineEdile", columnDefinition = "LONGBLOB")
    private byte[] immagineEdile;

    @Column(name = "descriptionEdile")
    private String descriptionEdile;

    @Column(name = "positionEdile")
    private String positionEdile;

    @ManyToOne
    private User user;


    public DenunciaEdile() {
    }

    public DenunciaEdile(Long id_DenunciaEdile, byte[] immagineEdile, String descriptionEdile, String positionEdile) {
        this.id_DenunciaEdile = id_DenunciaEdile;
        this.immagineEdile = immagineEdile;
        this.descriptionEdile = descriptionEdile;
        this.positionEdile = positionEdile;
    }

    public Long getId_DenunciaEdile() {
        return id_DenunciaEdile;
    }

    public void setId_DenunciaEdile(Long id_DenunciaEdile) {
        this.id_DenunciaEdile = id_DenunciaEdile;
    }

    public byte[] getImmagineEdile() {
        return immagineEdile;
    }

    public void setImmagineEdile(byte[] immagineEdile) {
        this.immagineEdile = immagineEdile;
    }

    public String getDescriptionEdile() {
        return descriptionEdile;
    }

    public void setDescriptionEdile(String descriptionEdile) {
        this.descriptionEdile = descriptionEdile;
    }

    public String getPositionEdile() {
        return positionEdile;
    }

    public void setPositionEdile(String positionEdile) {
        this.positionEdile = positionEdile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}