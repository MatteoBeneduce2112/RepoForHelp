package com.example.demo.repository;

import com.example.demo.model.DenunciaEdile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenunciaEdileRepository extends JpaRepository<DenunciaEdile, Long> {
}