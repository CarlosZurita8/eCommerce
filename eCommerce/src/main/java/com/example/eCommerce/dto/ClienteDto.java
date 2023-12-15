package com.example.eCommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDto {

    @NotNull
    @Pattern(regexp = "[6789][0-9]{9}",message = "Ingresar un numero de telefono valido")
    private String telefonoId;

    @NotNull
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}",message = "La contraseña debe tener de 8-15 caracteres incluido" +
            "A-Z,a-z,0-9, o un caracter especial characters")
    private String password;

    @Email
    private String emailId;

}
