package com.example.eCommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "DireccionUsuario")
public class DireccionUsuario {

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "direccionId")
    private Direccion direccion;

}
