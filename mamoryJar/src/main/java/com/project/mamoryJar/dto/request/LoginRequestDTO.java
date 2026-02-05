package com.project.mamoryJar.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {
    @NotBlank
    private String email;

    @NotBlank
    private String contraseña;
}
