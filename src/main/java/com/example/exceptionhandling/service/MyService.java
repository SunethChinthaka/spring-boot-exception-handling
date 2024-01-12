package com.example.exceptionhandling.service;

import com.example.exceptionhandling.exception.CustomNotFoundException;
import com.example.exceptionhandling.exception.CustomValidationException;
import com.example.exceptionhandling.model.Entity;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    public void findEntityById(Long id) {
        // Logic to find entity by ID

//        if (id == null) {
//            throw new CustomNotFoundException("Entity ID cannot be null");
//        }

        if (!id.equals(1L)) {
            throw new CustomNotFoundException("Entity not found with ID: " + id);
        }

        // Additional logic
        // make return type Entity
//        if (id == 1) {
//            // Simulating the presence of an entity with ID 1
//            Entity entity = new Entity();
//            entity.setId(1L);
//            entity.setName("Sample Entity 1");
//            return entity;
//        } else {
//            // Simulating the absence of an entity
//            throw new CustomNotFoundException("Entity not found with ID: " + id);
//        }
    }

    public void validateEntity(Entity entity) {
        // Logic to validate entity
        if (entity == null || entity.getName() == null || entity.getName().trim().isEmpty()) {
            throw new CustomValidationException("Entity name cannot be empty");
        }

        // Additional validation logic
    }
}
