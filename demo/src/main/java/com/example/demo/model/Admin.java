package com.example.demo.model;

import jakarta.persistence.*;
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
    private Denuncia id_denuncia;

    public Admin() {
    }

    public Admin(Long idAdmin, String email, String password, Denuncia id_denuncia) {
        this.idAdmin = idAdmin;
        this.email = email;
        this.password = password;
        this.id_denuncia = id_denuncia;
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

    public Denuncia getId_denuncia() {
        return id_denuncia;
    }

    public void setId_denuncia(Denuncia id_denuncia) {
        this.id_denuncia = id_denuncia;
    }

}