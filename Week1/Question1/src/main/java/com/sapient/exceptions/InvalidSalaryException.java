package com.sapient.exceptions;

public class InvalidSalaryException extends RuntimeException{
    public InvalidSalaryException(String message) {
        super(message);
    }
}
