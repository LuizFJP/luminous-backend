package com.br.luminous.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(
            UserNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        body.put("returned", ex.getCause());
        body.put("time", new Date().toString());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleException(
            AuthenticationException ex, WebRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        body.put("returned", "Unauthorized data");
        body.put("time", new Date().toString());

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(TipNotFoundException.class)
    public ResponseEntity<Object> handleTipNotFoundException(TipNotFoundException exception, WebRequest request){
        Map<String, Object> body = new HashMap<>();
        body.put("message", exception.getMessage());
        body.put("returned", exception.getCause());
        body.put("time", new Date().toString());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EnergyBillNotFoundException.class)
    public ResponseEntity<Object> handleEnergyBillNotFoundException(EnergyBillNotFoundException exception, WebRequest request){
        Map<String, Object> body = new HashMap<>();
        body.put("message", exception.getMessage());
        body.put("returned", exception.getCause());
        body.put("time", new Date().toString());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
