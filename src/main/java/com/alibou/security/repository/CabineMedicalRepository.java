package com.alibou.security.repository;

import com.alibou.security.model.CabineMedical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CabineMedicalRepository extends JpaRepository<CabineMedical, Integer> {

    Optional<CabineMedical> findCabineMedicalsByNom(String nom);
}
