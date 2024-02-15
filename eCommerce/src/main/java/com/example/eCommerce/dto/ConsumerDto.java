package com.example.eCommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerDto {

    @NotNull
    private String mobileId;

    @NotNull(message = "Por favor ingrese la contraseña")
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}",message = "¡La contraseña debe tener entre 8 y 15 caracteres y puede incluir A-Z, a-z, 0-9 o caracteres especiales! @#$%^&*_")
    private String password;

    @Email
    private String emailId;
}
