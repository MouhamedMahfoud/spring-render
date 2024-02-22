package com.alibou.security.repository;

import com.alibou.security.model.Moughataa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoughataaRepository extends JpaRepository<Moughataa, Integer> {
    Optional<Moughataa> findMoughataasByNom(String nom);
}
