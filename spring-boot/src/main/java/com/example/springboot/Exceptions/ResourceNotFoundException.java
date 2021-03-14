package com.example.springboot.Exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String str, Long id){
        super(str + id);
    }
}
