package com.example.exceptionhandling.exception;

public class ProductServiceException extends RuntimeException{
    public ProductServiceException(String message) {
        super(message);
    }
}
