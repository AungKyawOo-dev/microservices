package com.aungkyawoo.user_service.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Address Request Dto
 * Author : Aung Kyaw Oo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressRequestDto {
    @NotEmpty(message = "Line 1 should not be empty")
    private String line1;
    private String line2;
    @NotEmpty(message = "City should not be empty")
    private String city;
    @NotEmpty(message = "State should not be empty")
    private String state;
    @NotEmpty(message = "Postal code should not be empty")
    @Pattern(regexp = "[0-9]{5}", message = "Postal code should be 5 digits")
    private String postalCode;
    @NotEmpty(message = "Country should not be empty")
    private String country;
    @NotEmpty(message = "Is default should not be empty")
    private Boolean isDefault;
}
