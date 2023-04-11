package me.daegyeo.springtodo.exception;

import lombok.Getter;
import me.daegyeo.springtodo.error.ErrorCode;

@Getter
public class ServiceException extends RuntimeException {
    private final ErrorCode errorCode;

    public ServiceException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
