package com.example.exceptionhandling.handler;

import com.example.exceptionhandling.dto.ErrorDTO;
import com.example.exceptionhandling.exception.DuplicateProductException;
import com.example.exceptionhandling.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
