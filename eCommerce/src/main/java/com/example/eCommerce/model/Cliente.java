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
    private long usuarioId;
    @Column(name = "nombre_usuario")
    private String nombre;
    @Column(name = "apellido_usuario")
    private String apellido;
    @Column(name = "numero_telefono")
    private String numTelefono;

    //creamos una tabla para relacionar los clientes con las direcciones
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "cliente_direccion_map",  //enviamos la foreign key de la entidad local
            joinColumns = @JoinColumn(
                    name = "usuario_id",
                    referencedColumnName = "usuarioId"
            ),
            inverseJoinColumns = @JoinColumn(  //enviamos la foreign key de la entidad relacionada
                    name = "direccion_id",
                    referencedColumnName = "direccionId"
            )
    )
    private List<Direccion> direccionList;


    public Cliente(String nombre, String apellido, String numTelefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numTelefono = numTelefono;
    }
}
