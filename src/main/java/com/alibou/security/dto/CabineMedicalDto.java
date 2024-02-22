package com.alibou.security.dto;

import com.alibou.security.model.CabineMedical;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CabineMedicalDto {
    private Integer id;
    private String nom;
    private String tel;
    private String starthour;
    private String endhour;
    private String latlong;
    private CommuneDto commune;

    public static CabineMedicalDto fromEntity(CabineMedical cabineMedical){
        if (cabineMedical == null){
            return null;
        }
        return CabineMedicalDto.builder()
                .id(cabineMedical.getId())
                .nom(cabineMedical.getNom())
                .tel(cabineMedical.getTel())
                .starthour(cabineMedical.getStarthour())
                .endhour(cabineMedical.getEndhour())
                .latlong(cabineMedical.getLatlong())
                .commune(CommuneDto.fromEntity(cabineMedical.getCommune()))
                .build();
    }

    public static CabineMedical toEntity(CabineMedicalDto dto){
        if (dto == null){
            return null;
        }
        CabineMedical cabineMedical = new CabineMedical();
        cabineMedical.setId(dto.getId());
        cabineMedical.setNom(dto.getNom());
        cabineMedical.setTel(dto.getTel());
        cabineMedical.setStarthour(dto.getStarthour());
        cabineMedical.setEndhour(dto.getEndhour());
        cabineMedical.setLatlong(dto.getLatlong());
        cabineMedical.setCommune(CommuneDto.toEntity(dto.getCommune()));
        return cabineMedical;
    }
}
