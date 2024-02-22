package com.alibou.security.services;

import com.alibou.security.dto.CommuneDto;

import java.util.List;
public interface CommuneService {
    CommuneDto save(CommuneDto dto);
    CommuneDto findById(Integer id);
    CommuneDto findByName(String nom);
    List<CommuneDto> findAll();
    List<CommuneDto> findAllCommuneBayMoughataa(Integer idMoughataa);

    void delete(Integer id);
}
