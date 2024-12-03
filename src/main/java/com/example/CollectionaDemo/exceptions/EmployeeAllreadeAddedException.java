package com.example.CollectionaDemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAllreadeAddedException extends RuntimeException{
    public EmployeeAllreadeAddedException(String message) {
        super(message);
    }
}
