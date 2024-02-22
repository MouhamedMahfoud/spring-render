package com.alibou.security.services.impl;


import com.alibou.security.dto.PharmacieDto;
import com.alibou.security.exception.EntityNotFoundException;
import com.alibou.security.exception.ErrorCodes;
import com.alibou.security.exception.InvalidEntityException;
import com.alibou.security.model.Pharmacie;
import com.alibou.security.repository.PharmacieRepository;
import com.alibou.security.services.PharmacieService;
import com.alibou.security.validator.PharmacieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PharmacieServiceImpl implements PharmacieService {
    private PharmacieRepository pharmacieRepository;

    public PharmacieServiceImpl(PharmacieRepository pharmacieRepository) {
        this.pharmacieRepository = pharmacieRepository;
    }

    @Override
    public PharmacieDto save(PharmacieDto dto) {
        List<String> errors = PharmacieValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Pharmacie is note valid {}", dto);
            throw new InvalidEntityException("Pharmacie de pas valide", ErrorCodes.PHARMACIE_NOT_VALID,errors);
        }
        return PharmacieDto.fromEntity(
                pharmacieRepository.save(
                        PharmacieDto.toEntity(dto)
                )
        );
    }

    @Override
    public PharmacieDto findById(Integer id) {
        if(id == null){
            log.error("Wilaya Id Is null");
            return null;
        }
        Optional<Pharmacie> pharmacie = pharmacieRepository.findById(id);
        return Optional.of(PharmacieDto.fromEntity(pharmacie.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune Pharmacie avec l'ID = " +id+"  n' ete trouve dans la BDD ",ErrorCodes.PHARMACIE_NOT_FOUND)
        );
    }

    @Override
    public PharmacieDto findByName(String nom) {
        if(nom == null){
            log.error("Wilaya Id Is null");
            return null;
        }
        Optional<Pharmacie> pharmacie = pharmacieRepository.findPharmacieByNom(nom);
        return Optional.of(PharmacieDto.fromEntity(pharmacie.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune Pharmacie avec l'ID = " +nom+"  n' ete trouve dans la BDD ",ErrorCodes.PHARMACIE_NOT_FOUND)
        );
    }

    @Override
    public List<PharmacieDto> findAll() {
        return pharmacieRepository.findAll().stream()
                .map(PharmacieDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PharmacieDto> findAllPharmacieBayCommune(Integer idCommune) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Wilaya Name Is null");
            return;
        }
        pharmacieRepository.deleteById(id);
    }
}
