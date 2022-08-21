package com.example.jwt.exceptions.handler;

import com.example.jwt.exceptions.AlreadyExistException;
import com.example.jwt.exceptions.ExceptionResponse;
import com.example.jwt.exceptions.WrongPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.webjars.NotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlerNotFoundException(NotFoundException e) {

        return new ExceptionResponse(
                e.getClass().getSimpleName(),
                e.getMessage()
        );
    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public ExceptionResponse handlerAlreadyExistException(AlreadyExistException e) {
        return new ExceptionResponse(
                e.getClass().getSimpleName(),
                e.getMessage()
        );
    }

    @ExceptionHandler(WrongPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handlerWrongPasswordException(WrongPasswordException e) {
        return new ExceptionResponse(
                e.getClass().getSimpleName(),
                e.getMessage()
        );
    }
}
