package com.stardust.easyassess.core.exception;

public class ESAppException extends Exception {
    private int code;

    public ESAppException(String message, int code) {
        super(message);
        this.code = code;
    }
}
