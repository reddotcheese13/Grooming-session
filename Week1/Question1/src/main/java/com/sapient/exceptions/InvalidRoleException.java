package com.sapient.exceptions;

public class InvalidRoleException extends RuntimeException{
    public InvalidRoleException(String message) {
        super(message);
    }
}
