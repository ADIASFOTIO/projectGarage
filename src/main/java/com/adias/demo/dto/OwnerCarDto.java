package com.adias.demo.dto;;
import com.adias.demo.model.OwnerCar;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;
@Data
@Builder
public class OwnerCarDto {
    private String firstName;
    private String lastName;
    private String tel;
    private String mail;
    private AddressDto addressDto;
    private List<CarDto> carDtos;
    public static OwnerCarDto fromEntity(OwnerCar ownerCar) {
        if (ownerCar == null) {
            return null;
        }

        return OwnerCarDto.builder()
                .firstName(ownerCar.getFirstName())
                .lastName(ownerCar.getLastName())
                .tel(ownerCar.getTel())
                .mail(ownerCar.getMail())
                .addressDto(AddressDto.fromEntity(ownerCar.getAddress()))
                .carDtos(
                        ownerCar.getCars() != null ?
                                ownerCar.getCars().stream()
                                        .map(CarDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }
    public static OwnerCar toEntity(OwnerCarDto dto) {
        if (dto == null) {
            return null;
        }

        OwnerCar ownerCar = new OwnerCar();
        ownerCar.setFirstName(dto.getFirstName());
        ownerCar.setLastName(dto.getLastName());
        ownerCar.setMail(dto.getMail());
        ownerCar.setAddress(AddressDto.toEntity(dto.getAddressDto()));
        ownerCar.setTel(dto.getTel());

        return ownerCar;
    }
}
