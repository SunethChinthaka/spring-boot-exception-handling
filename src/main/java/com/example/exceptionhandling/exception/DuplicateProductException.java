package com.example.exceptionhandling.exception;

public class DuplicateProductException extends RuntimeException{
    public DuplicateProductException(String message) {
        super(message);
    }
}
