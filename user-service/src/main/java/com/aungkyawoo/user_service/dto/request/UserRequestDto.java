package com.aungkyawoo.user_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequestDto {
    private String email;
    private String fullName;
    private String phoneNumber;
}
