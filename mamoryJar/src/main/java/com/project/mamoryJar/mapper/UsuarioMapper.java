package com.project.mamoryJar.mapper;

import org.springframework.stereotype.Component;

import com.project.mamoryJar.dto.response.UsuarioResponseDTO;
import com.project.mamoryJar.model.entity.Usuario;

@Component
public class UsuarioMapper {
    
    public UsuarioResponseDTO mapToResponse(Usuario usuario){
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setDescripcion(usuario.getDescripcion());
        dto.setAvatar(usuario.getAvatar());
        dto.setLastLogin(usuario.getLastLogin());

        return dto;
    }
}
