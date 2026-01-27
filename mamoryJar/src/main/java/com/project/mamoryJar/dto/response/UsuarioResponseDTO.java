package com.project.mamoryJar.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private String email;
    private String descripcion;
    private String avatar;
    private LocalDateTime lastLogin;
}
