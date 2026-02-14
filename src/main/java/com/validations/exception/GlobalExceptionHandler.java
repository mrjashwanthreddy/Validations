package com.validations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Handle JSON Parse Errors (Type Mismatch)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleTypeMismatch(HttpMessageNotReadableException ex) {
        Map<String, String> errorResponse = new HashMap<>();

        // This is a generic message for malformed JSON
        errorResponse.put("error", "Malformed JSON request");
        errorResponse.put("details", "Invalid data type provided. Please check your JSON format.");

        // In a real app, you could parse 'ex.getMessage()' to find the exact field name,
        // but for now, let's keep it simple and safe.

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
