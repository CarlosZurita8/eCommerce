package com.example.eCommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "direccion")
@Getter
@Setter
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long direccionId;
    @Column(name = "calle")
    private String calle;
    @Column(name = "piso")
    private String piso;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "provincia")
    private String provincia;



    public Direccion(String calle, String piso, String departamento, String ciudad, String provincia) {
        this.calle = calle;
        this.piso = piso;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }
}
