package com.aungkyawoo.user_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Response Dto
 * Author : Aung Kyaw Oo
 */
@Data @AllArgsConstructor
public class ResponseDto {

    private String StatusCode;
    private String StatusMessage;
    private Object data;
}
