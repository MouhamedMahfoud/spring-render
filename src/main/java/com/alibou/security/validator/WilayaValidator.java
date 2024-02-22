package com.alibou.security.validator;

import com.alibou.security.dto.WilayaDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class WilayaValidator {
    public static List<String> validate(WilayaDto wilayaDto){
        List<String> errors = new ArrayList<>();
        if (wilayaDto == null || !StringUtils.hasLength(wilayaDto.getNom())){
            errors.add("Veuillez renseigner le nom de Wilaya");
        }
        return errors;
    }
}
