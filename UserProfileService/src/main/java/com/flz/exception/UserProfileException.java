package com.flz.exception;

import lombok.Getter;

@Getter
public class UserProfileException extends RuntimeException {

    private final ErrType type;

    public UserProfileException(ErrType type) {
        super(type.getMessage());
        this.type = type;
    }

    public UserProfileException(ErrType type, String message) {
        super(message);
        this.type = type;
    }

}