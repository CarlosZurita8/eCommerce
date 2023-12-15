package com.example.eCommerce.exception;

public class ClienteException extends RuntimeException{
    public ClienteException(){
        super();
    }
    public ClienteException(String mensaje){
        super(mensaje);
    }
}
