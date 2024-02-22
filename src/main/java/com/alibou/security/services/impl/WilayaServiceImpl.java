package com.alibou.security.services.impl;

import com.alibou.security.dto.WilayaDto;
import com.alibou.security.exception.EntityNotFoundException;
import com.alibou.security.exception.ErrorCodes;
import com.alibou.security.exception.InvalidEntityException;
import com.alibou.security.model.Wilaya;
import com.alibou.security.repository.WilayaRepository;
import com.alibou.security.services.WilayaService;
import com.alibou.security.validator.WilayaValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WilayaServiceImpl implements WilayaService {
    private WilayaRepository wilayaRepository;

    @Autowired
    public WilayaServiceImpl(WilayaRepository wilayaRepository) {
        this.wilayaRepository = wilayaRepository;
    }

    @Override
    public WilayaDto save(WilayaDto dto) {
        List<String> errors = WilayaValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Wilaya is not valid {}", dto);
            throw new InvalidEntityException("Wilaya de pas valide", ErrorCodes.WILAYA_NOT_VALID,errors);
        }
        return WilayaDto.formEntity(
                wilayaRepository.save(
                        WilayaDto.toEntity(dto)
                )
        );
    }

    @Override
    public WilayaDto findById(Integer id) {
        if(id == null){
            log.error("Wilaya Id Is null");
            return null;
        }
        System.out.println("find by id");
        Optional<Wilaya> wilaya = wilayaRepository.findById(id);
        return Optional.of(WilayaDto.formEntity(wilaya.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune Wilaya avec l'ID = " +id+"  n' ete trouve dans la BDD ",ErrorCodes.WILAYA_NOT_FOUND)
        );

    }

    @Override
    public WilayaDto findByName(String nom) {
        if(!StringUtils.hasLength(nom)){
            log.error("Wilaya Name Is null");
            return null;
        }
        Optional<Wilaya> wilaya = wilayaRepository.findWilayaByNom(nom);
        return Optional.of(WilayaDto.formEntity(wilaya.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune Wilaya avec le Nom = " +nom+"  n' ete trouve dans la BDD ",ErrorCodes.WILAYA_NOT_FOUND)
        );
    }

    @Override
    public List<WilayaDto> findAll() {
        return wilayaRepository.findAll().stream()
                .map(WilayaDto::formEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Wilaya Name Is null");
            return;
        }
        wilayaRepository.deleteById(id);
    }
}
