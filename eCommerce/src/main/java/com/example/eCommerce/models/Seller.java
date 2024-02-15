package com.example.eCommerce.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sellerId;

    @NotNull(message="Por favor ingrese su nombre")
    @Pattern(regexp = "[A-Za-z\\s]+",message = "Su nombre solo debe contener letras")
    private String firstName;

    @NotNull(message = "Por favor ingrese su apellido")
    @Pattern(regexp = "[A-Za-z\\s]+",message = "Su apellido solo debe contener letras")
    private String lastName;

    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}",message = "Por favor ingrese una contraseña valida")
    private String password;

    @NotNull(message = "Por favor ingrese su numero de telefono")
    @Column(unique = true)
    private String mobileNo;

    @Email
    @Column(unique = true)
    private String emailId;



}
