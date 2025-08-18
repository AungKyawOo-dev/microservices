package com.aungkyawoo.user_service.controller;

import com.aungkyawoo.user_service.constants.UserConstants;
import com.aungkyawoo.user_service.dto.UserDto;
import com.aungkyawoo.user_service.dto.request.CreateUserRequestDto;
import com.aungkyawoo.user_service.dto.response.ResponseDto;
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

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@RequestBody CreateUserRequestDto userRequestDto) {
        userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(UserConstants.STATUS_201, UserConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<UserDto> fetchUser(@RequestParam String email) {
        return ResponseEntity.ok(userService.fetchUser(email));
    }
}
