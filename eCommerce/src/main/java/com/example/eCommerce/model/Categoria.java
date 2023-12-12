package com.example.eCommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;


    public Categoria(String nombreCategoria){
        this.nombreCategoria= nombreCategoria;
    }
}
