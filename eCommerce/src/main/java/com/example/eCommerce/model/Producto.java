package com.example.eCommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "descripcion")
    private String descripcion;
    private String imagenProducto;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private List<ProductoItem>productoItems;

    public Producto(String nombreProducto, String descripcion, String imagenProducto) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.imagenProducto = imagenProducto;
    }
}
