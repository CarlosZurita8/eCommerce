package com.example.exception;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(){
        super();
    }

    public ClienteNotFoundException(String mensaje){
        super(mensaje);

    }
}
