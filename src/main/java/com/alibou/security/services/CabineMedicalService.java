package com.alibou.security.services;

import com.alibou.security.dto.CabineMedicalDto;

import java.util.List;
public interface CabineMedicalService {
    CabineMedicalDto save(CabineMedicalDto dto);
    CabineMedicalDto findById(Integer id);
    CabineMedicalDto findByName(String nom);
    List<CabineMedicalDto> findAll();
    List<CabineMedicalDto> findAllCabineMedicalBayCommune(Integer idCommune);
    void delete(Integer id);
}
