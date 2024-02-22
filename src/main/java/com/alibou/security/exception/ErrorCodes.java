package com.alibou.security.exception;

public enum ErrorCodes {
    // utilisateur
    UTILISATEUR_NOT_FOUND(12000),
    UTILISATEUR_NOT_VALID(12001),
    UTILISATEUR_ALREADY_EXISTENT(12002),
    UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID(12003),

    // wilaya
    WILAYA_NOT_FOUND(1000),
    WILAYA_NOT_VALID(1001),
    // MOUGHATAA
    MOUGHATAA_NOT_FOUND(2000),
    MOUGHATAA_NOT_VALID(2001),
    //COMMUNE
    COMMUNE_NOT_FOUND(3000),
    COMMUNE_NOT_VALID(3001),
    //Cabine Medical
    CABINEMEDICAL_NOT_FOUND(4000),
    CABINEMEDICAL_NOT_VALID(4001),

    PHARMACIE_NOT_FOUND(5000),
    PHARMACIE_NOT_VALID(5001),

    ;
    private int code;
    ErrorCodes(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}