package com.project.mamoryJar.model.entity;

import java.time.LocalDateTime;

import com.project.mamoryJar.model.domain.MemoryType;
import com.project.mamoryJar.model.domain.Mood;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "memory")
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "type")
    private MemoryType type;

    @Column(name = "mood")
    private Mood mood;

    private String location;

    // direccion de la imagen: ej en MySQL -> file_path = "/uploads/images/foto1.jpg"
    @Column(name = "file_path")
    private String filePath;

    private Boolean favorite;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jar_id", nullable = false)
    private Jar jar;
}
