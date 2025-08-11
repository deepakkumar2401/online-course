package com.te.online_course.controller;

import com.te.online_course.dto.ApiResponse;
import com.te.online_course.dto.RoleDto;
import com.te.online_course.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api-v1/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add-role")
    public ResponseEntity<ApiResponse> addRole(@RequestBody RoleDto roleDto) {
        return ResponseEntity.ok(new ApiResponse(false, "Role Added successfully", adminService.addRole(roleDto)));
    }
}
