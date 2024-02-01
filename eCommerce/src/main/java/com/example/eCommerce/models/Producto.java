package com.example.eCommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "producto")
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "descripcion")
    private String descripcion;
    private String imagenProducto;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    /*@OneToMany(mappedBy = "producto")
    private List<ProductoItem>productoItems;
    */
    public Producto(String nombreProducto, String descripcion, String imagenProducto) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.imagenProducto = imagenProducto;
    }
}
