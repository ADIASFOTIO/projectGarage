package com.adias.demo.validator;

import com.adias.demo.dto.RoleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleValidator {
    public static List<String> validate(RoleDto roleDto){
        List<String> errors = new ArrayList<>();
        if (roleDto == null){
            errors.add("compila il campo roleName");
            return errors;
        }
        if (!StringUtils.hasLength(roleDto.getRoleName())){
            errors.add("compila il campo roleName");
        }
        return errors;
    }
}
