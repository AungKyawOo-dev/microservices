package com.aungkyawoo.user_service.mapper;

import com.aungkyawoo.user_service.dto.AddressDto;
import com.aungkyawoo.user_service.dto.request.AddressRequestDto;
import com.aungkyawoo.user_service.entity.Address;
import com.aungkyawoo.user_service.util.StringUtils;

public class AddressMapper {
    public static void mapAddressDtoToAddress(AddressRequestDto addressRequestDto, Address address) {
        address.setLine1(addressRequestDto.getLine1());
        address.setLine2(addressRequestDto.getLine2());
        address.setCity(addressRequestDto.getCity());
        address.setState(addressRequestDto.getState());
        address.setPostalCode(addressRequestDto.getPostalCode());
        address.setCountry(addressRequestDto.getCountry());
    }

    public static Address mapAddressRequestDtoToAddress(AddressRequestDto addressRequestDto) {
        Address address = new Address();
        address.setId(StringUtils.getUUID());
        mapAddressDtoToAddress(addressRequestDto, address);
        return address;
    }

    public static AddressDto mapAddressToAddressDto(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .line1(address.getLine1())
                .line2(address.getLine2())
                .city(address.getCity())
                .state(address.getState())
                .postalCode(address.getPostalCode())
                .country(address.getCountry())
                .isDefault(address.getIsDefault())
                .build();
    }
}
