package com.alibou.security.services.impl;

import com.alibou.security.dto.UtilisateurDto;
import com.alibou.security.exception.EntityNotFoundException;
import com.alibou.security.exception.ErrorCodes;
import com.alibou.security.exception.InvalidEntityException;
import com.alibou.security.model.Utilisateur;
import com.alibou.security.repository.UtilisateurRepository;
import com.alibou.security.services.UtilisateurService;
import com.alibou.security.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Utilisateur is note valid {}", dto);
            throw new InvalidEntityException("Utilisateur de pas valide", ErrorCodes.WILAYA_NOT_VALID,errors);
        }
        return UtilisateurDto.fromEntity(
                utilisateurRepository.save(
                        UtilisateurDto.toEntity(dto)
                )
        );
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if(id == null){
            log.error("Utilisateur Id Is null");
            return null;
        }
        System.out.println("find by id");
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune Utilisateur avec l'ID = " +id+"  n' ete trouve dans la BDD ",ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Utilisateur Name Is null");
            return;
        }
        utilisateurRepository.deleteById(id);
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        if(!StringUtils.hasLength(email)){
            log.error("Utilisateur Email Is null");
            return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findUtilisateurByEmail(email);
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune utilisateur avec le Nom = " +email+"  n' ete trouve dans la BDD ",ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }
}
