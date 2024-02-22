package com.alibou.security.services;

import com.alibou.security.dto.MoughataaDto;

import java.util.List;
public interface MoughataaService {
    MoughataaDto save(MoughataaDto dto);
    MoughataaDto findById(Integer id);
    MoughataaDto findByName(String nom);
    List<MoughataaDto> findAll();
    List<MoughataaDto> findAllMoughataaByWilaya(Integer idWilaya);

    void delete(Integer id);
}
