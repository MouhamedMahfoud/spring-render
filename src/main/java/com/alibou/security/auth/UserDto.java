package com.alibou.security.auth;

import com.alibou.security.dto.MoughataaDto;
import com.alibou.security.dto.WilayaDto;
import com.alibou.security.model.Wilaya;
import com.alibou.security.user.Role;
import com.alibou.security.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class UserDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;

    public static UserDto formEntity(User wilaya){
        if(wilaya == null){
            return null;
            // TODO throw an exception
        }
        return UserDto.builder()
                .id(wilaya.getId())
                .firstname(wilaya.getFirstname())
                .lastname(wilaya.getLastname())
                .email(wilaya.getEmail())
                .role(wilaya.getRole())
                .build();
    }
    public static User toEntity(UserDto dto){
        if (dto == null){
            return null;
        }

        User wilaya = new User();
        wilaya.setId(dto.getId());
        wilaya.setFirstname(dto.getFirstname());
        wilaya.setLastname(dto.getLastname());
        wilaya.setEmail(dto.getEmail());
        wilaya.setPassword(dto.getPassword());
        return wilaya;
    }
}
