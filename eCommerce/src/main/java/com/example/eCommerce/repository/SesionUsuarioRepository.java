package com.example.repository;

import com.example.entities.SesionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SesionUsuarioRepository extends JpaRepository<SesionUsuario,Long> {
    Optional<SesionUsuario> findByToken(String token);
    Optional<SesionUsuario> findByUsuarioId(Long usuarioId);
}
