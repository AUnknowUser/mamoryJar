package com.project.mamoryJar.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.project.mamoryJar.model.domain.Rol;

import jakarta.persistence.*;

@Entity
@Data // getters y setters
@AllArgsConstructor // constructor con todos los argumentos
@NoArgsConstructor // genera constructor sin argumentos 
@Table(name = "user")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 105)
    private String email;

    @Column(nullable = false, unique = true ,length =  255)
    private String contraseña;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(length = 255)
    private String avatar;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "is_active")
    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private Rol rol;

    // mappedBy indica quien es el "dueño" de la relacion
    // orphanRemoval = true -> si una jar deja de pertenecer al usuario se elimina
    // Cascade.ALL no va en relaciones ManyToOne
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Jar> jars = new ArrayList<>();
}