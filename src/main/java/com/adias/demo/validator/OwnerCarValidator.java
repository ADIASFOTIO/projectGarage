package com.adias.demo.validator;
import com.adias.demo.dto.CarDto;
import com.adias.demo.dto.OwnerCarDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class OwnerCarValidator {
    public static List<String> validate(OwnerCarDto ownerCarDto) {
        List<String> errors = new ArrayList<>();
        if ((ownerCarDto == null) || !StringUtils.hasLength(ownerCarDto.getFirstName())) {
            errors.add("compila il campo Firstname");
        }
        if ((ownerCarDto == null) || !StringUtils.hasLength(ownerCarDto.getLastName())) {
            errors.add("compila il campo Lastname");
        }
        if ((ownerCarDto == null) || !StringUtils.hasLength(ownerCarDto.getMail())) {
            errors.add("compila il campo mail");
        }
        if ((ownerCarDto == null) || !StringUtils.hasLength(ownerCarDto.getTel())) {
            errors.add("compila il campo tel");
        }
        if (ownerCarDto.getAddressDto() == null){
            errors.add("compila il campo Address");
        }else {
            AddressValidator.validate(ownerCarDto.getAddressDto());
        }
        if (ownerCarDto.getCarDtos() == null){
            errors.add("compila il campo macchina");
        }else {
            for (CarDto carDto : ownerCarDto.getCarDtos()){
             errors.addAll(CarValidator.validate(carDto));
            }
        }
        return errors;
    }
}
