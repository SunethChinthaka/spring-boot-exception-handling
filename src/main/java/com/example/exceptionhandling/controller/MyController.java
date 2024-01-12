package com.example.exceptionhandling.controller;

import com.example.exceptionhandling.exception.CustomNotFoundException;
import com.example.exceptionhandling.exception.CustomValidationException;
import com.example.exceptionhandling.model.Entity;
import com.example.exceptionhandling.service.MyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {
    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/entity/{id}")
    public ResponseEntity<String> getEntityById(@PathVariable Long id) {
        try {
            myService.findEntityById(id);
            return ResponseEntity.ok("Entity found!");
        } catch (CustomNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateEntity(@RequestBody Entity entity) {
        try {
            myService.validateEntity(entity);
            return ResponseEntity.ok("Entity is valid!");
        } catch (CustomValidationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
