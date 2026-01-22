package com.project.mamoryJar.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jar")

public class Jar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "color")
    private String color;

    @Column(name = "icon")
    private String icon;

    @Column(name = "is_public")
    private Boolean isPublic;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // RELACION CON USUARIO
    //se usa el lazy para que no cargue toda la informacion del usuario al cargar la jar
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // RELACIÓN CON MEMORY
    @OneToMany(mappedBy = "jar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Memory> memories = new ArrayList<>();
}
