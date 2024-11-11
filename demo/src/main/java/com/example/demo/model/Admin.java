package com.example.demo.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;

    @Column(name = "emailAdmin")
    private String emailAdmin;

    @Column(name = "passwordAdmin")
    private String passwordAdmin;

    @ManyToOne
    private DenunciaPolizia id_denunciaPolizia;

    @ManyToOne
    private DenunciaEdile id_denunciaEdile;

    @ManyToOne
    private User id_user;

    public Admin() {
    }

    public Admin(Long idAdmin, String emailAdmin, String passwordAdmin, DenunciaPolizia id_denunciaPolizia, User id_user) {
        this.idAdmin = idAdmin;
        this.emailAdmin = emailAdmin;
        this.passwordAdmin = passwordAdmin;
        this.id_denunciaPolizia = id_denunciaPolizia;
        this.id_user = id_user;
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public DenunciaPolizia getId_denunciaPolizia() {
        return id_denunciaPolizia;
    }

    public void setId_denunciaPolizia(DenunciaPolizia id_denunciaPolizia) {
        this.id_denunciaPolizia = id_denunciaPolizia;
    }

    public DenunciaEdile getId_denunciaEdile() {
        return id_denunciaEdile;
    }

    public void setId_denunciaEdile(DenunciaEdile id_denunciaEdile) {
        this.id_denunciaEdile = id_denunciaEdile;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }
}