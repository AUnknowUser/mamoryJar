package com.project.mamoryJar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.mamoryJar.model.entity.Memory;

public interface MemoryRepository extends JpaRepository<Memory, Long> {
    // lista memorias
    List<Memory> findByJarId(Long jarId);
    // lista favoritos
    List<Memory> findByJarIdAndFavoriteTrue(Long jarId);
    // seguridad y validación 
    Optional<Memory> findByIdAndJarId(Long memoryId, Long jarId);
}

