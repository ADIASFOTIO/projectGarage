package com.adias.demo.dto;
import com.adias.demo.model.Address;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class AddressDto {
    private String address1;
    private String address2;
    private String cty;
    private String cap;
    private String country;
    public static AddressDto fromEntity(Address address) {
        if (address == null) {
            return null;
            // TODO TTHROW THE EXCEPTION
        }

        return AddressDto.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .cap(address.getCap())
                .cty(address.getCty())
                .country(address.getCountry())
                .build();
    }

    public static Address toEntity(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
            // TODO TTHROW THE EXCEPTION
        }
        Address address = new Address();
        address.setAddress1(addressDto.getAddress1());
        address.setAddress2(addressDto.getAddress2());
        address.setCap(addressDto.getCap());
        address.setCty(addressDto.getCty());
        address.setCountry(addressDto.getCountry());
        return address;
    }

}
