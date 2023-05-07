package com.adias.demo.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{
    @Getter
    private Error error;
    @Getter
    private List<String> errors;
    public InvalidEntityException(String message){
        super(message);
    }
    public InvalidEntityException(String message, Throwable cause){
        super(message, cause);
    }
    public InvalidEntityException(String message, Throwable cause, Error error){
        super(message, cause);
        this.error = error;
    }
    public InvalidEntityException(String message, Error error, List<String> errors){
        super(message);
        this.error = error;
        this.errors = errors;
    }
}
