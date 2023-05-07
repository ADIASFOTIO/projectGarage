package com.adias.demo.exception;

public enum ErrorCodes {
    //TODO COMPLETE THE RST OF ERROR
    ADDRESS_NOT_FOUND(1000),
    CAR_NOT_FOUND(2000),
    CAR_NOT_VALID(2001),
    OWNERCAR_NOT_FOUND(3000),
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
