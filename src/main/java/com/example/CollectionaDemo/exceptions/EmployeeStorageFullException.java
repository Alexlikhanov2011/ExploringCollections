package com.example.CollectionaDemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmployeeStorageFullException extends RuntimeException{
    public EmployeeStorageFullException(String message) {
        super(message);
    }
}
