package com.example.exceptionhandling.service;

import com.example.exceptionhandling.exception.CustomNotFoundException;
import com.example.exceptionhandling.exception.CustomValidationException;
import com.example.exceptionhandling.model.Entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MyServiceTest {

    @InjectMocks
    private MyService service;
    @Mock
    private Entity entity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

//        entity = mock(Entity.class);
//        service = new MyService();
    }

    @Test
    void shouldNotThrowExceptionForEntityFound() {
        // Arrange
        when(entity.getName()).thenReturn("TestEntity");

        // Act
        service.findEntityById(1L);

        // Assert - No exception should be thrown
    }

    @Test
    void shouldThrowNotFoundExceptionForEntityNotFound() {
        // Arrange
        when(entity.getName()).thenReturn("TestEntity");

        // Act and Assert
        assertThrows(CustomNotFoundException.class, () -> service.findEntityById(2L));
    }

    @Test
    void shouldNotThrowExceptionForValidEntity() {
        // Arrange
        when(entity.getName()).thenReturn("TestEntity");

        // Act
        service.validateEntity(entity);

        // Assert - No exception should be thrown
    }

    @Test
    void shouldThrowValidationExceptionForInvalidEntity() {
        // Arrange
        when(entity.getName()).thenReturn(null);

        // Act and Assert
        assertThrows(CustomValidationException.class, () -> service.validateEntity(entity));
    }

    @Test
    void shouldThrowValidationExceptionForNullEntity() {
        // Arrange
        when(entity.getName()).thenReturn(null);

        // Act and Assert
        assertThrows(CustomValidationException.class, () -> service.validateEntity(null));
    }
}