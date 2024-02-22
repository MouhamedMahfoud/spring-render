package com.alibou.security.controller;

import com.alibou.security.controller.api.CabineMedicalApi;
import com.alibou.security.dto.CabineMedicalDto;
import com.alibou.security.services.CabineMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:4200")
public class CabineMedicalController implements CabineMedicalApi {
    private CabineMedicalService cabineMedicalService;

    @Autowired
    public CabineMedicalController(CabineMedicalService cabineMedicalService) {
        this.cabineMedicalService = cabineMedicalService;
    }

    @Override
    public ResponseEntity<CabineMedicalDto> save(CabineMedicalDto dto) {
        return ResponseEntity.ok(cabineMedicalService.save(dto));
    }

    @Override
    public ResponseEntity<CabineMedicalDto> findById(Integer id) {
        return ResponseEntity.ok(cabineMedicalService.findById(id));
    }

    @Override
    public ResponseEntity<CabineMedicalDto >findByName(String nom) {
        return ResponseEntity.ok(cabineMedicalService.findByName(nom));
    }

    @Override
    public ResponseEntity<List<CabineMedicalDto>> findAll() {
        return ResponseEntity.ok(cabineMedicalService.findAll());
    }

    @Override
    public ResponseEntity<List<CabineMedicalDto>> findAllCabineMedicalBayCommune(Integer idCommune) {
        return null;
    }

    @Override
    public ResponseEntity delete(Integer id) {
        cabineMedicalService.delete(id);
        return ResponseEntity.ok().build();
    }
}
