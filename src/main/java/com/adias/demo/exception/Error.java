package com.adias.demo.exception;

public enum Error {
    //TODO COMPLETE THE RST OF ERROR
    ADDRESS_NOT_FOUND(1000),
    CAR_NOT_FOUND(2000),
    OWNERCAR_NOT_FOUND(3000),
    ROLE_NOT_FOUND(4000),
    USERR_NOT_FOUND(5000),
    ;
    private int code;
    Error(int code){
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
