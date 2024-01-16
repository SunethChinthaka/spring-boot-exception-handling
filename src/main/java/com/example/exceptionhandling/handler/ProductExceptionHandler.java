package com.example.exceptionhandling.handler;

import com.example.exceptionhandling.dto.ErrorDTO;
import com.example.exceptionhandling.exception.DuplicateProductException;
import com.example.exceptionhandling.exception.ProductNotFoundException;
import com.example.exceptionhandling.exception.ProductServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ProductExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ProblemDetail handleProductNotFoundException(ProductNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());

             /*   return ErrorDTO.builder()
                .status("FAIL")
                .errorMessage(ex.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR).build();*/
    }

    @ExceptionHandler(DuplicateProductException.class)
    public ProblemDetail handleDuplicateProductException(DuplicateProductException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(ProductServiceException.class)
    public ProblemDetail handleProductServiceException(ProductServiceException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errorsMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errorsMap.put(error.getField(), error.getDefaultMessage()));
        return errorsMap;
    }
}
