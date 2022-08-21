package com.example.jwt.exceptions;

public class WrongPasswordException extends RuntimeException{

    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
