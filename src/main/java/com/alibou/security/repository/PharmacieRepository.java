package com.alibou.security.repository;

import com.alibou.security.model.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer> {
    Optional<Pharmacie> findPharmacieByNom(String nom);
}
