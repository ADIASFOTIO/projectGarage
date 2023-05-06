package com.adias.demo.validator;

import com.adias.demo.dto.CarDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CarValidator {
    public static List<String> validate(CarDto carDto){
        List<String> errors = new ArrayList<>();
        if ((carDto == null) || !StringUtils.hasLength(carDto.getRegisterNumber())){
            errors.add("compila il campo RegisterNumber");
        }
        if ((carDto == null) || !StringUtils.hasLength(carDto.getModel())){
            errors.add("compila il campo Model");
        }

        return errors;
    }
}
