package com.alibou.security.services.impl;

import com.alibou.security.dto.CabineMedicalDto;
import com.alibou.security.exception.EntityNotFoundException;
import com.alibou.security.exception.ErrorCodes;
import com.alibou.security.exception.InvalidEntityException;
import com.alibou.security.model.CabineMedical;
import com.alibou.security.repository.CabineMedicalRepository;
import com.alibou.security.services.CabineMedicalService;
import com.alibou.security.validator.CabineMedicalValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CabineMedicalServiceImpl implements CabineMedicalService {
    private CabineMedicalRepository cabineMedicalRepository;

    @Autowired
    public CabineMedicalServiceImpl(CabineMedicalRepository cabineMedicalRepository) {
        this.cabineMedicalRepository = cabineMedicalRepository;
    }


    @Override
    public CabineMedicalDto save(CabineMedicalDto dto) {
        List<String> errors = CabineMedicalValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Cabine Medical is note valid {}", dto);
            throw new InvalidEntityException("Cabine Medical de pas valide", ErrorCodes.CABINEMEDICAL_NOT_VALID,errors);
        }
        return CabineMedicalDto.fromEntity(
                cabineMedicalRepository.save(
                        CabineMedicalDto.toEntity(dto)
                )
        );
    }

    @Override
    public CabineMedicalDto findById(Integer id) {
        if(id == null) {
            log.error("Cabine medical Id Is null");
            return null;
        }
        System.out.println("find by id");
        Optional<CabineMedical> cabineMedical = cabineMedicalRepository.findById(id);
        return Optional.of(CabineMedicalDto.fromEntity(cabineMedical.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune Wilaya avec l'ID = " +id+"  n' ete trouve dans la BDD ",ErrorCodes.CABINEMEDICAL_NOT_FOUND)
        );
    }

    @Override
    public CabineMedicalDto findByName(String nom) {
        if(nom == null) {
            log.error("Cabine medical name Is null");
            return null;
        }
        Optional<CabineMedical> cabineMedical = cabineMedicalRepository.findCabineMedicalsByNom(nom);
        return Optional.of(CabineMedicalDto.fromEntity(cabineMedical.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune Cabine medical  avec le Nom = " +nom+"  n' ete trouve dans la BDD ", ErrorCodes.CABINEMEDICAL_NOT_FOUND)
        );
    }

    @Override
    public List<CabineMedicalDto> findAll() {
        return cabineMedicalRepository.findAll().stream()
                .map(CabineMedicalDto::fromEntity)
                .collect(Collectors.toList()
                );
    }

    @Override
    public List<CabineMedicalDto> findAllCabineMedicalBayCommune(Integer idCommune) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Cabine medical Name Is null");
            return;
        }
        cabineMedicalRepository.deleteById(id);
    }
}
