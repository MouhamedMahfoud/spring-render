package com.alibou.security.controller;
import com.alibou.security.controller.api.UtilisateurApi;
import com.alibou.security.dto.UtilisateurDto;
import com.alibou.security.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:4200")
public class UtilisateurController implements UtilisateurApi {
    private UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public ResponseEntity<UtilisateurDto> save(UtilisateurDto dto) {
        return ResponseEntity.ok(utilisateurService.save(dto));
    }

    @Override
    public ResponseEntity<UtilisateurDto> findById(Integer id) {
        return ResponseEntity.ok(utilisateurService.findById(id));
    }

    @Override
    public ResponseEntity<List<UtilisateurDto>> findAll() {
        return ResponseEntity.ok(utilisateurService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        utilisateurService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UtilisateurDto> findByEmail(String email) {
        return null;
    }
}
