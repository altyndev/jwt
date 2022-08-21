package com.example.jwt.exceptions;

public class AlreadyExistException extends RuntimeException{

    public AlreadyExistException() {
    }

    public AlreadyExistException(String message) {
        super(message);
    }
}
