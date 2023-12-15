package com.example.eCommerce.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usuarioId;

    @Column(name = "nombre_usuario")
    @NotNull(message = "El primer nombre no puede ser nulo")
    @Pattern(regexp = "[A-Za-z.\\s]+",message = "Ingrese caracteres validos para el primer nombre")
    private String nombre;

    @Column(name = "apellido_usuario")
    @NotNull(message = "El apellido no puede ser nulo")
    @Pattern(regexp = "[A-Za-z.\\s]+",message = "Ingrese caracteres validos para el apellido")
    private String apellido;

    @Column(name = "numero_telefono")
    @NotNull(message = "Por favor ingrese el numero de telefono")
    @Pattern(regexp = "[6789]{1}[0-9]{9}",message = "Ingrese un numero de telefono de 10 digitos valido")
    private String numTelefono;

    private LocalDateTime fechaCreacion;

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
