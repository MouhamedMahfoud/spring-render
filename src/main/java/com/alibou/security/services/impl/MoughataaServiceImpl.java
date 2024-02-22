package com.alibou.security.services.impl;

import com.alibou.security.dto.MoughataaDto;
import com.alibou.security.exception.EntityNotFoundException;
import com.alibou.security.exception.ErrorCodes;
import com.alibou.security.exception.InvalidEntityException;
import com.alibou.security.model.Moughataa;
import com.alibou.security.repository.MoughataaRepository;
import com.alibou.security.services.MoughataaService;
import com.alibou.security.validator.MoughataaValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MoughataaServiceImpl implements MoughataaService {
    private MoughataaRepository moughataaRepository;


    @Autowired
    public MoughataaServiceImpl(MoughataaRepository moughataaRepository) {
        this.moughataaRepository = moughataaRepository;
    }

    @Override
    public MoughataaDto save(MoughataaDto dto) {
        List<String> errors = MoughataaValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Moughataa is note valid {}",dto);
            throw new InvalidEntityException("", ErrorCodes.MOUGHATAA_NOT_FOUND,errors);
        }
        return MoughataaDto.fromEntity(moughataaRepository.save(MoughataaDto.toEntity(dto)));
    }

    @Override
    public MoughataaDto findById(Integer id) {
        if(id == null){
            log.error("Moughataa name Is null");
            return null;
        }
        Optional<Moughataa> moughataa = moughataaRepository.findById(id);
        return Optional.of(MoughataaDto.fromEntity(moughataa.get()))
                .orElseThrow(()->
                        new EntityNotFoundException("Aucune Wilaya avec l'ID = " +id+"  n' ete trouve dans la BDD ",ErrorCodes.WILAYA_NOT_FOUND)
                );
    }

    @Override
    public MoughataaDto findByName(String nom) {
        if(!StringUtils.hasLength(nom)){
            log.error("Moughataa name Is null");
            return null;
        }
        Optional<Moughataa> moughataa = moughataaRepository.findMoughataasByNom(nom);
        return Optional.of(MoughataaDto.fromEntity(moughataa.get()))
                .orElseThrow(()->
                        new EntityNotFoundException("Aucune Moughataa avec le Nom = " +nom+"  n' ete trouve dans la BDD ",ErrorCodes.WILAYA_NOT_FOUND)
                );
    }

    @Override
    public List<MoughataaDto> findAll() {
        return moughataaRepository.findAll().stream()
                .map(MoughataaDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MoughataaDto> findAllMoughataaByWilaya(Integer idWilaya) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Wilaya Name Is null");
            return;
        }
        moughataaRepository.deleteById(id);
    }
}
