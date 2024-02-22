package com.alibou.security.services;
import com.alibou.security.dto.PharmacieDto;

import java.util.List;
public interface PharmacieService {
    PharmacieDto save(PharmacieDto dto);
    PharmacieDto findById(Integer id);
    PharmacieDto findByName(String nom);
    List<PharmacieDto> findAll();
    List<PharmacieDto> findAllPharmacieBayCommune(Integer idCommune);
    void delete(Integer id);
}
