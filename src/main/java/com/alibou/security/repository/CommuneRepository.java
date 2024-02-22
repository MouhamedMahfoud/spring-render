package com.alibou.security.repository;

import com.alibou.security.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommuneRepository extends JpaRepository<Commune, Integer> {
    Optional<Commune> findCommuneByNom(String nom);
}
