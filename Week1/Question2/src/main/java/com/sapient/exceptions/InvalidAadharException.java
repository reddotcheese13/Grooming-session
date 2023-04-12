package com.sapient.exceptions;

public class InvalidAadharException extends RuntimeException{
    public InvalidAadharException(String message) {
        super(message);
    }
}
