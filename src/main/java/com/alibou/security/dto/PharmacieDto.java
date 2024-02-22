package com.alibou.security.dto;

import com.alibou.security.model.Pharmacie;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PharmacieDto {
    private Integer id;
    private String nom;
    private String tel;
    private String starthour;
    private String endhour;
    private String latlong;
    //    private MoughataaDto moughataa;
    private CommuneDto commune;
    public static PharmacieDto fromEntity(Pharmacie pharmacie){
        if (pharmacie == null){
            return null;
        }
        return PharmacieDto.builder()
                .id(pharmacie.getId())
                .nom(pharmacie.getNom())
                .tel(pharmacie.getTel())
                .starthour(pharmacie.getStarthour())
                .endhour(pharmacie.getEndhour())
                .latlong(pharmacie.getLatlong())
//                .moughataa(MoughataaDto.fromEntity(pharmacie.getMoughataa()))
                .commune(CommuneDto.fromEntity(pharmacie.getCommune()))
                .build();
    }
    public static Pharmacie toEntity(PharmacieDto dto){
        if (dto == null){
            return null;
        }
        Pharmacie pharmacie = new Pharmacie();
        pharmacie.setId(dto.getId());
        pharmacie.setNom(dto.getNom());
        pharmacie.setTel(dto.getTel());
        pharmacie.setStarthour(dto.getStarthour());
        pharmacie.setEndhour(dto.getEndhour());
        pharmacie.setLatlong(dto.getLatlong());
//        pharmacie.setMoughataa(MoughataaDto.toEntity(dto.getMoughataa()));
        pharmacie.setCommune(CommuneDto.toEntity(dto.getCommune()));
        return pharmacie;
    }
}
