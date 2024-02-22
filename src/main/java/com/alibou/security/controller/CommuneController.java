package com.alibou.security.controller;

import com.alibou.security.controller.api.CommuneApi;
import com.alibou.security.dto.CommuneDto;
import com.alibou.security.services.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:4200")
public class CommuneController implements CommuneApi {
    private CommuneService communeService;

    @Autowired
    public CommuneController(CommuneService communeService) {
        this.communeService = communeService;
    }

    @Override
    public ResponseEntity<CommuneDto> save(CommuneDto dto) {
        return ResponseEntity.ok(communeService.save(dto));
    }

    @Override
    public ResponseEntity<CommuneDto> findById(Integer id) {
        return ResponseEntity.ok(communeService.findById(id));
    }

    @Override
    public ResponseEntity<CommuneDto> findByName(String nom) {
        return ResponseEntity.ok(communeService.findByName(nom));
    }

    @Override
    public ResponseEntity<List<CommuneDto>> findAll() {
        return ResponseEntity.ok(communeService.findAll());
    }

    @Override
    public ResponseEntity<List<CommuneDto>> findAllCommuneBayMoughataa(Integer idMoughataa) {
        return null;
    }

    @Override
    public ResponseEntity delete(Integer id) {
        communeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
