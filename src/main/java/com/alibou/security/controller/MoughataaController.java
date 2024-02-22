package com.alibou.security.controller;
import com.alibou.security.controller.api.MoughataaApi;
import com.alibou.security.dto.MoughataaDto;
import com.alibou.security.services.MoughataaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
//@CrossOrigin("http://localhost:4200")
public class MoughataaController implements MoughataaApi {
    private MoughataaService moughataaService;

    @Autowired
    public MoughataaController(MoughataaService moughataaService) {
        this.moughataaService = moughataaService;
    }

    @Override
    public ResponseEntity<MoughataaDto> save(MoughataaDto dto) {
        return ResponseEntity.ok(moughataaService.save(dto));
    }

    @Override
    public ResponseEntity<MoughataaDto> findById(Integer id) {
        return ResponseEntity.ok(moughataaService.findById(id));
    }

    @Override
    public ResponseEntity<MoughataaDto> findByName(String nom) {
        return ResponseEntity.ok(moughataaService.findByName(nom));
    }

    @Override
    public ResponseEntity<List<MoughataaDto>> findAll() {
        return ResponseEntity.ok(moughataaService.findAll());
    }

    @Override
    public ResponseEntity<List<MoughataaDto>> findAllMoughataaByWilaya(Integer idWilaya) {
        return ResponseEntity.ok(moughataaService.findAllMoughataaByWilaya(idWilaya));
    }

    @Override
    public ResponseEntity delete(Integer id) {

        moughataaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
