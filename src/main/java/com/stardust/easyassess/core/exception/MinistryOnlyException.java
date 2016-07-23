package com.stardust.easyassess.core.exception;

public class MinistryOnlyException extends MessageException {
    public MinistryOnlyException() {
        super("该操作仅限于卫生机构用户");
    }
}
