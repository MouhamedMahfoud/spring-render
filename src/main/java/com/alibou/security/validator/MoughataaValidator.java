package com.alibou.security.validator;

import com.alibou.security.dto.MoughataaDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MoughataaValidator {
    public static List<String> validate(MoughataaDto moughataaDto){
        List<String> errors = new ArrayList<>();
        if (moughataaDto == null || !StringUtils.hasLength(moughataaDto.getNom())){
            errors.add("Veuillez renseigner le nom de Moughataa");
        }
        return errors;
    }
}
