package com.te.online_course.exception;

import com.te.online_course.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(DataFoundException.class)
    public ResponseEntity<ApiResponse> dataFound(Exception e) {
        return ResponseEntity.badRequest().body(new ApiResponse(true, e.getMessage(), null));
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ApiResponse> dataNotFound(Exception e) {
        return ResponseEntity.badRequest().body(new ApiResponse(true, e.getMessage(), null));
    }
}
