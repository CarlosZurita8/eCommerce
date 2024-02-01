package com.example.eCommerce.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    /*@Pattern(regexp = "/^(?:(?:00)?549?)?0?(?:11|[2368]\\d)(?:(?=\\d{0,2}15)\\d{2})??\\d{8}$/",message = "Ingrese un numero de telefono de 10 digitos valido")
    verificar numero para argentina con codigo de area...pendiente,lo dejo asi para que entre cualquier numero por el momento*/
    private String numTelefono;

    @NotNull
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}",message = "¡La contraseña debe tener entre 8 y 15 caracteres y puede incluir A-Z, a-z, 0-9 o caracteres especiales! @#$%^&*_")
    private String password;

    @Column(name = "fecha_creacion")
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
