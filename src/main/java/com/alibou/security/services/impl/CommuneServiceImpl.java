package com.alibou.security.services.impl;

import com.alibou.security.dto.CommuneDto;
import com.alibou.security.exception.EntityNotFoundException;
import com.alibou.security.exception.ErrorCodes;
import com.alibou.security.exception.InvalidEntityException;
import com.alibou.security.model.Commune;
import com.alibou.security.repository.CommuneRepository;
import com.alibou.security.services.CommuneService;
import com.alibou.security.validator.CommuneValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommuneServiceImpl implements CommuneService {
    private CommuneRepository communeRepository;

    public CommuneServiceImpl(CommuneRepository communeRepository) {
        this.communeRepository = communeRepository;
    }

    @Override
    public CommuneDto save(CommuneDto dto) {
        List<String> errors = CommuneValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Wilaya is note valid {}", dto);
            throw new InvalidEntityException("Wilaya de pas valide", ErrorCodes.WILAYA_NOT_VALID,errors);
        }
        return CommuneDto.fromEntity(
                communeRepository.save(
                        CommuneDto.toEntity(dto)
                )
        );
    }

    @Override
    public CommuneDto findById(Integer id) {
        if(id == null){
            log.error("Wilaya Id Is null");
            return null;
        }
        System.out.println("find by id");
        Optional<Commune> commune = communeRepository.findById(id);
        return Optional.of(CommuneDto.fromEntity(commune.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune Wilaya avec l'ID = " +id+"  n' ete trouve dans la BDD ",ErrorCodes.COMMUNE_NOT_FOUND)
        );
    }

    @Override
    public CommuneDto findByName(String nom) {
        if(!StringUtils.hasLength(nom)){
            log.error("Wilaya Name Is null");
            return null;
        }
        Optional<Commune> commune = communeRepository.findCommuneByNom(nom);
        return Optional.of(CommuneDto.fromEntity(commune.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune Wilaya avec le Nom = " +nom+"  n' ete trouve dans la BDD ",ErrorCodes.COMMUNE_NOT_FOUND)
        );
    }

    @Override
    public List<CommuneDto> findAll() {
        return communeRepository.findAll().stream()
                .map(CommuneDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommuneDto> findAllCommuneBayMoughataa(Integer idMoughataa) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Commune Name Is null");
            return;
        }
        communeRepository.deleteById(id);
    }
}
