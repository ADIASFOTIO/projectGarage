package com.adias.demo.exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{
    @Getter
    private Error error;
    public EntityNotFoundException(String message){
        super(message);
    }
    public EntityNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    public EntityNotFoundException(String message, Throwable cause, Error error){
        super(message, cause);
        this.error = error;
    }
    public EntityNotFoundException(String message, Error error){
        super(message);
        this.error = error;
    }
}
