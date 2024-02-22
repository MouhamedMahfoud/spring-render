package com.alibou.security.validator;

import com.alibou.security.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();
        if (utilisateurDto == null){
            errors.add("Veuillez renseigner le Nom d'utilisateur");
            errors.add("Veuillez renseigner le Prenom d'utilisateur");
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
            errors.add("Veuillez renseigner email d'utilisateur");
            return errors;
        }
        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Veuillez renseigner le Nom d'utilisateur");
            return errors;
        }
        if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Veuillez renseigner le Prenom d'utilisateur");
            return errors;
        }
        if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
            return errors;
        }
        if (!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("Veuillez renseigner email d'utilisateur");
            return errors;
        }
        return errors;
    }
}
