package com.alibou.security.validator;

import com.alibou.security.dto.PharmacieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PharmacieValidator {
    public static List<String> validate(PharmacieDto pharmacieDto){
        List<String> errors = new ArrayList<>();
        if (pharmacieDto == null){
            errors.add("Veuillez renseigner le nom de Pharmacie");
            errors.add("Veuillez renseigner le tel de Pharmacie");
            errors.add("Veuillez renseigner le latitude et longitude de Pharmacie");
            return errors;
        }
        if(!StringUtils.hasLength(pharmacieDto.getNom())){
            errors.add("Veuillez renseigner le nom de Pharmacie");
            return errors;
        }
        if(!StringUtils.hasLength(pharmacieDto.getTel())){
            errors.add("Veuillez renseigner le tel de Pharmacie");
            return errors;
        }
        if(!StringUtils.hasLength(pharmacieDto.getLatlong())){
            errors.add("Veuillez renseigner le latitude et longitude de Pharmacie");
            return errors;
        }
        return errors;
    }
}
