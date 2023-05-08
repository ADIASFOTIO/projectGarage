package com.adias.demo.validator;
import com.adias.demo.dto.CarDto;
import com.adias.demo.dto.ClientDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDto clientDto) {
        List<String> errors = new ArrayList<>();
        if ((clientDto == null) || !StringUtils.hasLength(clientDto.getFirstName())) {
            errors.add("compila il campo Firstname");
        }
        if ((clientDto == null) || !StringUtils.hasLength(clientDto.getLastName())) {
            errors.add("compila il campo Lastname");
        }
        if ((clientDto == null) || !StringUtils.hasLength(clientDto.getMail())) {
            errors.add("compila il campo mail");
        }
        if ((clientDto == null) || !StringUtils.hasLength(clientDto.getTel())) {
            errors.add("compila il campo tel");
        }
        if (clientDto.getAddressDto() == null){
            errors.add("compila il campo Address");
        }else {
            AddressValidator.validate(clientDto.getAddressDto());
        }
        if (clientDto.getCarDtos() == null){
            errors.add("compila il campo macchina");
        }else {
            for (CarDto carDto : clientDto.getCarDtos()){
             errors.addAll(CarValidator.validate(carDto));
            }
        }
        return errors;
    }
}
