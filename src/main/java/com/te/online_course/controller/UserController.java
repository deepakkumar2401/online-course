package com.te.online_course.controller;

import com.te.online_course.dto.ApiResponse;
import com.te.online_course.dto.LoginDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/api-v1/")
public class UserController {


    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody @Valid LoginDto loginDto) {
        return ResponseEntity.ok(new ApiResponse(false, "Login successfull", null));
    }
}
