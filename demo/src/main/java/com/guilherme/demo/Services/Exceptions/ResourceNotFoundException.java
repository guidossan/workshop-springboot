package com.guilherme.demo.Services.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resurce not found. ID: "+id);
    }
}
