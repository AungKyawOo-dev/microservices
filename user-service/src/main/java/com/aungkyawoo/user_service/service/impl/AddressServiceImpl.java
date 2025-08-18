package com.aungkyawoo.user_service.service.impl;

import com.aungkyawoo.user_service.repository.AddressRepository;
import com.aungkyawoo.user_service.service.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl {
    private final AddressRepository addressRepository;
}
