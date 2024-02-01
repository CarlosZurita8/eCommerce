package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    //area de controlador de excepcion personalizado
    @ExceptionHandler(ClienteException.class)
    public ResponseEntity<DetalleDeError> clienteNotFoundExceptionHandler(ClienteNotFoundException cnfe, WebRequest wr){
        DetalleDeError err = new DetalleDeError(LocalDateTime.now(),cnfe.getMessage(),wr.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<DetalleDeError> clienteExceptionHandler(ClienteException ce, WebRequest wr){
        DetalleDeError err = new DetalleDeError(LocalDateTime.now(),ce.getMessage(),wr.getDescription(false));
        return new ResponseEntity<>(err,HttpStatus.FORBIDDEN);
    }

}
