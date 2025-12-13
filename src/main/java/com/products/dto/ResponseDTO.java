package com.products.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO {
    private Integer statusCode;
    private String message;
    private Object data;
}
