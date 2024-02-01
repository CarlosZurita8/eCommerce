package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "categoria")
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;


    public Categoria(String nombreCategoria){
        this.nombreCategoria= nombreCategoria;
    }
}
