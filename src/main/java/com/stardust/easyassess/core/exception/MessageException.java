package com.stardust.easyassess.core.exception;

public class MessageException extends ESAppException {
    public MessageException(String error, int code) {
        super(error, code);
    }
}
