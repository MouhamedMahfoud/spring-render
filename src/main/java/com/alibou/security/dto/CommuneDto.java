package com.alibou.security.dto;

import com.alibou.security.model.Commune;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommuneDto {
    private Integer id;

    private String nom;

    private String description;

    private MoughataaDto moughataa;

    public static CommuneDto fromEntity(Commune commune){
        if (commune == null){
            return null;
        }
        return CommuneDto.builder()
                .id(commune.getId())
                .nom(commune.getNom())
                .description(commune.getDescription())
                .moughataa(MoughataaDto.fromEntity(commune.getMoughataa()))
                .build();
    }
    public static Commune toEntity(CommuneDto dto){
        if(dto == null){
            return null;
        }
        Commune commune = new Commune();
        commune.setId(dto.getId());
        commune.setNom(dto.getNom());
        commune.setDescription(dto.getDescription());
        commune.setMoughataa(MoughataaDto.toEntity(dto.getMoughataa()));
        return commune;
    }
}
