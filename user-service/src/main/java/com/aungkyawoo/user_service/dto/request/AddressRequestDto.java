package com.aungkyawoo.user_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressRequestDto {
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Boolean isDefault;
}
