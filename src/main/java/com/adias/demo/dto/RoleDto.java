package com.adias.demo.dto;
import com.adias.demo.model.Role;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class RoleDto {
    private String roleName;
    private UserrDto userrDto;
    public static RoleDto fromEntity(Role role) {
        if (role == null) {
            return null;
            //TODO THROW AND EXCEPTION
        }
        return RoleDto.builder()
                .roleName(role.getRoleName())
                .userrDto(UserrDto.fromEntity(role.getUserr()))
                .build();
    }
    public static Role toEntity (RoleDto dto){
        if (dto == null) {
            return null;
            //TODO THROW AND EXCEPTION
        }
        Role role = new Role();
        role.setRoleName(dto.getRoleName());
        role.setUserr(UserrDto.toEntity(dto.getUserrDto()));
        return role;
    }
}
