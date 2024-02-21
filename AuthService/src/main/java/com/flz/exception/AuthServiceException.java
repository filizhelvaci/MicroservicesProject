package com.flz.exception;

import lombok.Getter;

import javax.lang.model.type.ErrorType;

@Getter
public class AuthServiceException extends RuntimeException {

    private final ErrType type;

    public AuthServiceException(ErrType type) {
        super(type.getMessage());
        this.type = type;
    }

    public AuthServiceException(ErrType type, String message) {
        super(message);
        this.type = type;
    }

}