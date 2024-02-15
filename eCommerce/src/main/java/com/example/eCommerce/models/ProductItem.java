/*package com.example.eCommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "producto_item")
public class ProductoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int cantidadEnStock;
    private String imagenProducto;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "producto_item_id")
    private ProductoItem productoItem;

    public ProductoItem(int cantidadEnStock, String imagenProducto, double precio) {
        this.cantidadEnStock = cantidadEnStock;
        this.imagenProducto = imagenProducto;
        this.precio = precio;
    }

}
*/