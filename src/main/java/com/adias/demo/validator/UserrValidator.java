package com.adias.demo.validator;
import com.adias.demo.dto.UserrDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserrValidator {
    public static List<String> validate(UserrDto userrDto){
      List<String> errors = new ArrayList<>();
        if ((userrDto == null) || !StringUtils.hasLength(userrDto.getFirstName())){
            errors.add("compila il campo Firstname");
        }
        if ((userrDto == null) || !StringUtils.hasLength(userrDto.getLastName())){
            errors.add("compila il campo Lastname");
        }
        if ((userrDto == null) || !StringUtils.hasLength(userrDto.getMail())){
            errors.add("compila il campo mail");
        }
        if ((userrDto == null) || !StringUtils.hasLength(userrDto.getTel())){
            errors.add("compila il campo tel");
        }
        if ((userrDto == null) || !StringUtils.hasLength(userrDto.getPassword())){
            errors.add("compila il campo Password");
        }
        if (userrDto.getAddressDto() == null){
            errors.add("compila il campo Address");
        }else {
            errors.addAll(AddressValidator.validate(userrDto.getAddressDto()));
        }
        if (userrDto.getDateOfBurn() == null){
            errors.add("compila il campo data di nascità");
        }
        return errors;
    }
}
