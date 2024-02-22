package com.alibou.security.validator;

import com.alibou.security.dto.CabineMedicalDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CabineMedicalValidator {
    public static List<String> validate(CabineMedicalDto cabineMedicalDto){
        List<String> errors = new ArrayList<>();
        if (cabineMedicalDto == null){
            errors.add("Veuillez renseigner le nom de cabineMedical");
            errors.add("Veuillez renseigner le tel de cabineMedical");
            errors.add("Veuillez renseigner le latitude et longitude de cabineMedical");
            return errors;
        }
        if(!StringUtils.hasLength(cabineMedicalDto.getNom())){
            errors.add("Veuillez renseigner le nom de cabineMedical");
            return errors;
        }
        if(!StringUtils.hasLength(cabineMedicalDto.getTel())){
            errors.add("Veuillez renseigner le tel de cabineMedical");
            return errors;
        }
        if(!StringUtils.hasLength(cabineMedicalDto.getLatlong())){
            errors.add("Veuillez renseigner le latitude et longitude de cabineMedical");
            return errors;
        }
        return errors;
    }
}
