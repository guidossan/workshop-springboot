package com.guilherme.demo.resurces.Exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.guilherme.demo.Services.Exceptions.DatabaseException;
import com.guilherme.demo.Services.Exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

// intercepta as execções para o objeto executar
@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resurceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found exception";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> resurceNotFound(DatabaseException e, HttpServletRequest request){
        String error = "Data base error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
