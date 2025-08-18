package com.aungkyawoo.user_service.mapper;

import com.aungkyawoo.user_service.dto.request.CreateUserRequestDto;
import com.aungkyawoo.user_service.entity.User;

public class UserMapper {
    public static User mapUserDtoToUser(CreateUserRequestDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }
}
