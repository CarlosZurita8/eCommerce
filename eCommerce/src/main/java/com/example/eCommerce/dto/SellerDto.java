package com.example.eCommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerDto {

    @NotNull(message = "Por favor ingrese su numero de telefono")
    private String mobileNo;

    @Pattern(regexp="[A-Za-z0-9!@#$%^&*_]{8,15}", message="Por favor ingrese una contraseña valida")
    private String password;
}
