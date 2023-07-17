package com.kai.common.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class ApplicationException extends RuntimeException{
    public ApplicationException(String message) {
        super(message);
    }
    public ApplicationException(Throwable cause) {
        super(cause);
    }
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
