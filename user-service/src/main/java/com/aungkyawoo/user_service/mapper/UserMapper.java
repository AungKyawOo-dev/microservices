package com.aungkyawoo.user_service.mapper;

import com.aungkyawoo.user_service.dto.UserDto;
import com.aungkyawoo.user_service.dto.request.UserRequestDto;
import com.aungkyawoo.user_service.entity.User;

import java.util.stream.Collectors;

/**
 * User Mapper
 * Author: Aung Kyaw Oo
 */
public class UserMapper {

    /**
     * Map user dto to user
     * @param userDto UserRequestDto
     * @param user User
     */
    public static void mapUserDtoToUser(UserRequestDto userDto, User user) {
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setPhoneNumber(userDto.getPhoneNumber());
    }

    /**
     * Map user to user dto
     * @param user User
     * @return UserDto
     */
    public static UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .phoneNumber(user.getPhoneNumber())
                .addresses(user.getAddresses().stream()
                        .map(AddressMapper::mapAddressToAddressDto)
                        .collect(Collectors.toList()))
                .build();
    }

}
