package com.example.demo.repository;

import com.example.demo.model.DenunciaPolizia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenunciaPoliziaRepository extends JpaRepository<DenunciaPolizia, Long> {
}
