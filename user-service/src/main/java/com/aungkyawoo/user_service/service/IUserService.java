package com.aungkyawoo.user_service.service;

import com.aungkyawoo.user_service.dto.UserDto;
import com.aungkyawoo.user_service.dto.request.UserRequestDto;

/**
 * User Service
 * Author : Aung Kyaw Oo
 */
public interface IUserService {

    /**
     * Create User
     * @param userRequestDto UserRequestDto
     * @return UserDto
     */
    UserDto createUser(UserRequestDto userRequestDto);

    /**
     * Fetch User
     * @param email String
     * @return UserDto
     */
    UserDto fetchUser(String email);

    /**
     * Update User
     * @param id String
     * @param userRequestDto UserRequestDto
     */
    void updateUser(String id, UserRequestDto userRequestDto);

    /**
     * Delete User
     * @param id String
     */
    void deleteUser(String id);
}
