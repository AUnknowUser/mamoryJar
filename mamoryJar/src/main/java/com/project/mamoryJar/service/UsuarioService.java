package com.project.mamoryJar.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.project.mamoryJar.dto.request.UsuarioRequestDTO;
import com.project.mamoryJar.dto.response.UsuarioResponseDTO;
import com.project.mamoryJar.model.entity.Usuario;
import com.project.mamoryJar.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private UsuarioResponseDTO mapToResponse(Usuario usuario){
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setDescripcion(usuario.getDescripcion());
        dto.setAvatar(usuario.getAvatar());
        dto.setLastLogin(usuario.getLastLogin());

        return dto;
    }

    // para escrituras & cambios no para lecturas simples
    @Transactional 
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto){
        if (usuarioRepository.existByEmail(dto.getEmail())) {
            throw new IllegalStateException("El correo ya se encuentra registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setRol(dto.getRol());

        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setContraseña(dto.getContraseña());

        usuario.setAvatar(dto.getAvatar());
        usuario.setDescripcion(dto.getDescripcion());

        usuarioRepository.save(usuario);
        return mapToResponse(usuario);
    }


    public UsuarioResponseDTO buscarUsuarioPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return mapToResponse(usuario);
    }


    @Transactional
    public List<UsuarioResponseDTO> listarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll(); // devuelve una lista (vacía si no hay registros, nunca null).
        List<UsuarioResponseDTO> response = new ArrayList<>();

        for(Usuario usuario : usuarios){
            response.add(mapToResponse(usuario));
        }

        return response;
    }

    public void eliminarUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("El usuario ha sido encontrado"));
    
        usuarioRepository.delete(usuario);
    }


    
}
