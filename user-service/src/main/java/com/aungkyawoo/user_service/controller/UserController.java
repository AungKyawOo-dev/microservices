package com.aungkyawoo.user_service.controller;

import com.aungkyawoo.user_service.constants.UserConstants;
import com.aungkyawoo.user_service.dto.AddressDto;
import com.aungkyawoo.user_service.dto.UserDto;
import com.aungkyawoo.user_service.dto.request.AddressRequestDto;
import com.aungkyawoo.user_service.dto.request.UserRequestDto;
import com.aungkyawoo.user_service.dto.response.ResponseDto;
import com.aungkyawoo.user_service.service.IAddressService;
import com.aungkyawoo.user_service.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * User Controller
 * Author : Aung Kyaw Oo
 */
@Controller
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    /** Injecting IUserService and IAddressService */
    private final IUserService userService;
    /** Injecting IAddressService */
    private final IAddressService addressService;

    /**
     * Create User
     * @param userRequestDto UserRequestDto
     * @return ResponseDto
     */
    @PostMapping
    public ResponseEntity<ResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserDto userDto = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(UserConstants.STATUS_201, UserConstants.MESSAGE_201, userDto));
    }

    /**
     * Fetch User
     * @param id String
     * @return UserDto
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> fetchUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.fetchUser(id));
    }

    /**
     * Update User
     * @param id String
     * @param userRequestDto UserRequestDto
     * @return ResponseDto
     */
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateUser(@PathVariable String id, @RequestBody UserRequestDto userRequestDto) {
        userService.updateUser(id, userRequestDto);
        return ResponseEntity.ok(new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200, userRequestDto));
    }

    /**
     * Delete User
     * @param id String
     * @return ResponseDto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200, null));
    }

    /**
     * Create Address
     * @param userId String
     * @param addressRequestDto AddressRequestDto
     *
     * @return ResponseDto
     */
    @PostMapping("/{userId}/address")
    public ResponseEntity<ResponseDto> createAddress(@PathVariable String userId, @RequestBody AddressRequestDto  addressRequestDto) {
        AddressDto addressDto = addressService.createAddress(userId, addressRequestDto);
        return ResponseEntity.ok(new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200, addressDto));

    }

    /**
     * Fetch Address
     * @param userId String
     * @return ResponseDto
     */
    @GetMapping("/{userId}/address")
    public ResponseEntity<ResponseDto> fetchAddress(@PathVariable String userId) {
        return ResponseEntity.ok(new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200,   addressService.fetchAddress(userId)));
    }
}
