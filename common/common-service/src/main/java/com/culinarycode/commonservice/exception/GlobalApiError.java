package com.culinarycode.commonservice.exception;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude( value = JsonInclude.Include.NON_NULL)
public record GlobalApiError(String message, Map<String, String> validationErrors ) {
}
