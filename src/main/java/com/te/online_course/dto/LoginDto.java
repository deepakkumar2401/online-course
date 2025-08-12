package com.te.online_course.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDto {

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;
}
