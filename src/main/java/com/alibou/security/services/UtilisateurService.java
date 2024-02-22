package com.alibou.security.services;

import com.alibou.security.dto.UtilisateurDto;

import java.util.List;
public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto dto);
    UtilisateurDto findById(Integer id);
    List<UtilisateurDto> findAll();
    void delete(Integer id);
    UtilisateurDto findByEmail(String email);
}
