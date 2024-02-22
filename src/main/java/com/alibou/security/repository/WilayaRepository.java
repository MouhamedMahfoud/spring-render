package com.alibou.security.repository;

import com.alibou.security.model.Wilaya;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WilayaRepository extends JpaRepository<Wilaya, Integer> {
    Optional<Wilaya> findWilayaByNom(String nom);
}
