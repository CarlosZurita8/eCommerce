package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleDeError {

    private LocalDateTime marcarDeTiempo;
    private String mensaje;
    private String detalle;
}
