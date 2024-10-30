package com.example.demo.repository;

import com.example.demo.model.DenunciaPolizia;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenunciaPoliziaRepository extends JpaRepository<DenunciaPolizia, Long> {
    int countByUserId(User userId);
    DenunciaPolizia findImageByUserId(User userId);
}