package me.daegyeo.springtodo.error;

public class ErrorResponse {
    private int httpStatus;
    private String message;
    private String code;

    public ErrorResponse(ErrorCode errorCode) {
        this.httpStatus = errorCode.getHttpStatus();
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }
}
