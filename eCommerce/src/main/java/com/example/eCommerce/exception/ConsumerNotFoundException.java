package com.example.eCommerce.exception;

public class ConsumerNotFoundException extends RuntimeException {

    public ConsumerNotFoundException(){
        super();
    }

    public ConsumerNotFoundException(String message){
        super(message);

    }
}
