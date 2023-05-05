package com.adias.demo.dto;
import com.adias.demo.model.Userr;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
@Data
@Builder
public class UserrDto {
    private String firstName;
    private String lastName;
    private String mail;
    private String tel;
    private Instant dateOfBurn;
    private String photo;
    private AddressDto addressDto;
    private List<RoleDto> roleDtos;
    private List<CarDto> carDtos;
    public static UserrDto fromEntity(Userr userr){
        if (userr == null) {
            return null;
        }
        return UserrDto.builder()
                .firstName(userr.getFirstName())
                .lastName(userr.getLastName())
                .mail(userr.getMail())
                .tel(userr.getTel())
                .dateOfBurn(userr.getDateOfBurn())
                .photo(userr.getPhoto())
                .addressDto(AddressDto.fromEntity(userr.getAddress()))
                .roleDtos(userr.getRoles() != null ?
                        userr.getRoles().stream()
                             .map(RoleDto::fromEntity)
                                .collect(Collectors.toList()) : null
                )
                .carDtos(userr.getCars() != null ?
                        userr.getCars().stream()
                                .map(CarDto::fromEntity)
                                .collect(Collectors.toList()) : null
                )
                .build();
    }
    public static Userr toEntity(UserrDto dto){
        if (dto == null) {
            return null;
        }
        Userr userr = new Userr();
        userr.setFirstName(dto.getFirstName());
        userr.setLastName(dto.getLastName());
        userr.setMail(dto.getMail());
        userr.setTel(dto.getTel());
        userr.setDateOfBurn(dto.getDateOfBurn());
        userr.setPhoto(dto.getPhoto());
        userr.setAddress(AddressDto.toEntity(dto.getAddressDto()));
        return userr;
    }
}
