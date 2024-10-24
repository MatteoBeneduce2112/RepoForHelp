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

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    private DenunciaPolizia id_denunciaPolizia;

    @ManyToOne
    private DenunciaEdile id_denunciaEdile;
    public Admin() {
    }

    public Admin(Long idAdmin, String email, String password, DenunciaPolizia id_denunciaPolizia) {
        this.idAdmin = idAdmin;
        this.email = email;
        this.password = password;
        this.id_denunciaPolizia = id_denunciaPolizia;
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}