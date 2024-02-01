package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class SesionUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sesionId;

    @Column(unique = true)
    private String token;

    @Column(unique = true)
    private Long usuarioId;

    private String tipoUsuario;

}
