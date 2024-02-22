package com.alibou.security.dto;

import com.alibou.security.model.Moughataa;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MoughataaDto {
    private Integer id;
    private String nom;
    private String description;

    private WilayaDto wilaya;

//    private List<CommuneDto> communes;
//    private List<PharmacieDto> pharmacies;
//    private List<CabineMedicalDto> cabineMedicals;

    public static MoughataaDto fromEntity(Moughataa moughataa){
        if (moughataa == null){
            return null;
        }
        return MoughataaDto.builder()
                .id(moughataa.getId())
                .nom(moughataa.getNom())
                .description(moughataa.getDescription())
                .wilaya(WilayaDto.formEntity(moughataa.getWilaya()))
                .build();
    }

    public static Moughataa toEntity(MoughataaDto dto){
        if(dto == null){
            return null;
        }
        Moughataa moughataa = new Moughataa();
        moughataa.setId(dto.getId());
        moughataa.setNom(dto.getNom());
        moughataa.setDescription(dto.getDescription());
        moughataa.setWilaya(WilayaDto.toEntity(dto.getWilaya()));
        return moughataa;
    }
}
