package com.alibou.security.controller;
import com.alibou.security.controller.api.WilayaApi;
import com.alibou.security.dto.WilayaDto;
import com.alibou.security.services.WilayaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
//@CrossOrigin("http://localhost:4200")
public class WiayaController implements WilayaApi {
    private WilayaService wilayaService;
    @Autowired
    public WiayaController(WilayaService wilayaService) {
        this.wilayaService = wilayaService;
    }

    @Override
    public ResponseEntity<WilayaDto> save(WilayaDto dto) {

        return ResponseEntity.ok(wilayaService.save(dto));
    }

    @Override
    public ResponseEntity<WilayaDto> findById(Integer id) {
        return ResponseEntity.ok(wilayaService.findById(id));
    }

    @Override
    public ResponseEntity<WilayaDto> findByName(String nom) {
        return ResponseEntity.ok(wilayaService.findByName(nom));
    }

    @Override
    public ResponseEntity<List<WilayaDto>> findAll() {
        return ResponseEntity.ok(wilayaService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        wilayaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
