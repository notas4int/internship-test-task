package com.artem.projects.internshiptesttask.controllers;

import com.artem.projects.internshiptesttask.exceptions.ExceptionResponse;
import com.artem.projects.internshiptesttask.exceptions.InputStringEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(InputStringEmptyException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundExceptions(RuntimeException e,
                                                                      HttpServletRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(request.getRequestURI(), e.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
