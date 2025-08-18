package com.aungkyawoo.user_service.mapper;

import com.aungkyawoo.user_service.dto.UserDto;
import com.aungkyawoo.user_service.dto.request.UserRequestDto;
import com.aungkyawoo.user_service.entity.User;

public class UserMapper {
    public static void mapUserDtoToUser(UserRequestDto userDto, User user) {
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setPhoneNumber(userDto.getPhoneNumber());
    }

    public static UserDto mapUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFullName(user.getFullName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        return userDto;
    }

}
