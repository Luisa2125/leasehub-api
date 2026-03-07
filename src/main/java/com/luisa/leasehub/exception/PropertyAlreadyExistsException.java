package com.luisa.leasehub.exception;

public class PropertyAlreadyExistsException extends RuntimeException{
    public PropertyAlreadyExistsException(String message){
        super(message);
    }
}
