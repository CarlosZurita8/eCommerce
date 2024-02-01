package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "direccion")
@Getter
@Setter
@Data
@NoArgsConstructor
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
