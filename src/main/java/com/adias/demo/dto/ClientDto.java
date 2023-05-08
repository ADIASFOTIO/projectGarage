package com.adias.demo.dto;;
import com.adias.demo.model.Client;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;
@Data
@Builder
public class ClientDto {
    private String firstName;
    private String lastName;
    private String tel;
    private String mail;
    private AddressDto addressDto;
    private List<CarDto> carDtos;
    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
        }

        return ClientDto.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .tel(client.getTel())
                .mail(client.getMail())
                .addressDto(AddressDto.fromEntity(client.getAddress()))
                .carDtos(
                        client.getCars() != null ?
                                client.getCars().stream()
                                        .map(CarDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }
    public static Client toEntity(ClientDto dto) {
        if (dto == null) {
            return null;
        }

        Client client = new Client();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setMail(dto.getMail());
        client.setAddress(AddressDto.toEntity(dto.getAddressDto()));
        client.setTel(dto.getTel());

        return client;
    }
}
