package com.example.eCommerce.exception;

public class ConsumerException extends RuntimeException{
    public ConsumerException(){
        super();
    }
    public ConsumerException(String message){
        super(message);
    }
}
