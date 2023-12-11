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
    private long Id;
    private String calle;
    private String piso;
    private String departamento;
    private String ciudad;
    private String provincia;

    @OneToMany(mappedBy = "direccion")
    private List<DireccionUsuario> direccionUsuario;

    public Direccion(String calle, String piso, String departamento, String ciudad, String provincia) {
        this.calle = calle;
        this.piso = piso;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }
}
