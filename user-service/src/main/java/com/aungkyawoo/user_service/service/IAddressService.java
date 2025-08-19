package com.aungkyawoo.user_service.service;

import com.aungkyawoo.user_service.dto.AddressDto;
import com.aungkyawoo.user_service.dto.request.AddressRequestDto;

public interface IAddressService {
    AddressDto createAddress(String id, AddressRequestDto addressRequestDto);

    Object fetchAddress(String id);
}
