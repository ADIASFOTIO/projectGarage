package com.adias.demo.exception;

public enum ErrorCodes {
    //TODO COMPLETE THE RST OF ERROR
    ADDRESS_NOT_FOUND(1000),
    CAR_NOT_FOUND(2000),
    CAR_NOT_VALID(2001),
    CLIENT_NOT_FOUND(3000),
    CLIENT_NOT_VALID(3001),
    CLIENT_ALREADY_IN_USE(3002),
    ROLE_NOT_FOUND(4000),
    USERR_NOT_FOUND(5000),
    ;
    private int code;
    ErrorCodes(int code){

        this.code = code;
    }
    public int getCode() {

        return code;
    }
}
