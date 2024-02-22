package com.alibou.security.services;

import com.alibou.security.dto.WilayaDto;

import java.util.List;
public interface WilayaService {
    WilayaDto save(WilayaDto dto);
    WilayaDto findById(Integer id);
    WilayaDto findByName(String nom);
    List<WilayaDto> findAll();

    void delete(Integer id);
}
