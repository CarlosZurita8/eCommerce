package com.example.eCommerce.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "nombre_usuario")
    private String nombre;
    @Column(name = "apellido_usuario")
    private String apellido;
    @Column(name = "numero_telefono")
    private String numTelefono;

    @OneToMany(mappedBy = "usuario")
    private List<DireccionUsuario> direccionUsuario;


    public Cliente(String nombre, String apellido, String numTelefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numTelefono = numTelefono;
    }
}
