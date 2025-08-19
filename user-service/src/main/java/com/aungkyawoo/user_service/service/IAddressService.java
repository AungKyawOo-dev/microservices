package com.aungkyawoo.user_service.service;

import com.aungkyawoo.user_service.dto.AddressDto;
import com.aungkyawoo.user_service.dto.request.AddressRequestDto;

/**
 * Address Service Interface
 * Author : Aung Kyaw Oo
 */
public interface IAddressService {

    /**
     * Create Address
     * @param id String
     * @param addressRequestDto AddressRequestDto
     * @return AddressDto
     */
    AddressDto createAddress(String id, AddressRequestDto addressRequestDto);

    /**
     * Fetch Address
     * @param id String
     * @return Object
     */
    Object fetchAddress(String id);
}
