package com.aungkyawoo.user_service.service.impl;

import com.aungkyawoo.user_service.dto.AddressDto;
import com.aungkyawoo.user_service.dto.request.AddressRequestDto;
import com.aungkyawoo.user_service.entity.Address;
import com.aungkyawoo.user_service.entity.User;
import com.aungkyawoo.user_service.exception.ResourceNotFoundException;
import com.aungkyawoo.user_service.mapper.AddressMapper;
import com.aungkyawoo.user_service.repository.AddressRepository;
import com.aungkyawoo.user_service.repository.UserRepository;
import com.aungkyawoo.user_service.service.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {

    /** Inject AddressRepository */
    private final AddressRepository addressRepository;

    private final UserRepository userRepository;

    @Override
    public AddressDto createAddress(String id, AddressRequestDto addressRequestDto) {
        Address address = AddressMapper.mapAddressRequestDtoToAddress(addressRequestDto);
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            address.setUser(user);
        }
        addressRepository.save(address);
        return AddressMapper.mapAddressToAddressDto(address);
    }

    @Override
    public List<AddressDto> fetchAddress(String id) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("User", "ID", id));
        return user.getAddresses().stream().map(AddressMapper::mapAddressToAddressDto).toList();
    }
}
