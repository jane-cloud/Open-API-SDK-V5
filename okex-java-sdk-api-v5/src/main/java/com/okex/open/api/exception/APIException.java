package com.okex.open.api.exception;

public class APIException extends RuntimeException {

    private int code;

    public APIException(String message) {
        super(message);
    }

    public APIException(int code, String message) {
        super(message);
        this.code = code;
    }


    public APIException(Throwable cause) {
        super(cause);
    }

    public APIException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        if (this.code != 0) {
            return this.code + " : " + super.getMessage();
        }
        return super.getMessage();
    }
}
