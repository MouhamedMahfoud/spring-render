package com.alibou.security.dto;

import com.alibou.security.model.Wilaya;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class WilayaDto {
    private Integer id;
    private String nom;
    private String description;

    @JsonIgnore
    private List<MoughataaDto> moughataas;

    public static WilayaDto formEntity(Wilaya wilaya){
        if(wilaya == null){
            return null;
            // TODO throw an exception
        }
        return WilayaDto.builder()
                .id(wilaya.getId())
                .nom(wilaya.getNom())
                .description(wilaya.getDescription())
                .build();
    }
    public static Wilaya toEntity(WilayaDto dto){
        if (dto == null){
            return null;
        }
        // mapping de WilayaDto -> wilaya
        Wilaya wilaya = new Wilaya();
        wilaya.setId(dto.getId());
        wilaya.setNom(dto.getNom());
        wilaya.setDescription(dto.getDescription());
        return wilaya;
    }
}
