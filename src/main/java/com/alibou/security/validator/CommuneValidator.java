package com.alibou.security.validator;

import com.alibou.security.dto.CommuneDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommuneValidator {
    public static List<String> validate(CommuneDto communeDto){
        List<String> errors = new ArrayList<>();
        if(communeDto == null || !StringUtils.hasLength(communeDto.getNom())){
            errors.add("Veuillez renseigner le nom de Commune");
        }
        return errors;
    }
}
