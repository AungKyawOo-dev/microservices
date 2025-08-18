package com.aungkyawoo.user_service.service;

import com.aungkyawoo.user_service.dto.UserDto;
import com.aungkyawoo.user_service.dto.request.CreateUserRequestDto;

public interface IUserService {
    void createUser(CreateUserRequestDto userRequestDto);

    UserDto fetchUser(String email);
}
