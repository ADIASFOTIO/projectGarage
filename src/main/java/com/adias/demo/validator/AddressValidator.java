package com.adias.demo.validator;
import com.adias.demo.dto.AddressDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class AddressValidator {
    public static List<String> validate(AddressDto addressDto){
        List<String> errors = new ArrayList<>();
        if ((addressDto == null) || !StringUtils.hasLength(addressDto.getAddress1())){
            errors.add("compila il campo");
        }
        if ((addressDto == null) || !StringUtils.hasLength(addressDto.getCap())){
            errors.add("compila il Cap");
        }
        if ((addressDto == null) || !StringUtils.hasLength(addressDto.getCty())){
            errors.add("compila il campo Address");
        }
        return errors;
    }
}
