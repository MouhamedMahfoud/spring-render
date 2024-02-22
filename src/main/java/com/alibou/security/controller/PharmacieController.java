package com.alibou.security.controller;
import com.alibou.security.controller.api.PharmacieApi;
import com.alibou.security.dto.PharmacieDto;
import com.alibou.security.services.PharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:4200")
public class PharmacieController implements PharmacieApi {
    private PharmacieService pharmacieService;

    @Autowired
    public PharmacieController(PharmacieService pharmacieService) {
        this.pharmacieService = pharmacieService;
    }

    @Override
    public ResponseEntity<PharmacieDto> save(PharmacieDto dto) {
        return ResponseEntity.ok(pharmacieService.save(dto));
    }

    @Override
    public ResponseEntity<PharmacieDto> findById(Integer id) {
        return ResponseEntity.ok(pharmacieService.findById(id));
    }

    @Override
    public ResponseEntity<PharmacieDto> findByName(String nom) {
        return ResponseEntity.ok(pharmacieService.findByName(nom));
    }

    @Override
    public ResponseEntity<List<PharmacieDto>> findAll() {
        return ResponseEntity.ok(pharmacieService.findAll());
    }

    @Override
    public ResponseEntity<List<PharmacieDto>> findAllPharmacieBayCommune(Integer idCommune) {
        return null;
    }

    @Override
    public ResponseEntity delete(Integer id) {
        pharmacieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
