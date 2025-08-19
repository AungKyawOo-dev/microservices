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

@Controller
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;
    private final IAddressService addressService;

    @PostMapping
    public ResponseEntity<ResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserDto userDto = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(UserConstants.STATUS_201, UserConstants.MESSAGE_201, userDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> fetchUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.fetchUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateUser(@PathVariable String id, @RequestBody UserRequestDto userRequestDto) {
        userService.updateUser(id, userRequestDto);
        return ResponseEntity.ok(new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200, userRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200, null));
    }

    @PostMapping("/{id}/address")
    public ResponseEntity<ResponseDto> createAddress(@PathVariable String id, @RequestBody AddressRequestDto  addressRequestDto) {
        AddressDto addressDto = addressService.createAddress(id, addressRequestDto);
        return ResponseEntity.ok(new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200, addressDto));

    }

    @GetMapping("/{id}/address")
    public ResponseEntity<ResponseDto> fetchAddress(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200,   addressService.fetchAddress(id)));
    }
}
