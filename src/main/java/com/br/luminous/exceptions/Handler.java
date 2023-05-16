package com.br.luminous.exceptions;

import jakarta.servlet.http.HttpServletRequest;
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

        return getObjectResponseEntity(
                ex.getMessage(),
                "User does not exist in the system",
                ex,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Object> handleEmailAlreadyExistsException(
            EmailAlreadyExistsException ex, WebRequest request) {

        return getObjectResponseEntity(
                ex.getMessage(),
                "Try use another email",
                ex,
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthenticationException(
            AuthenticationException ex, WebRequest request) {

        return getObjectResponseEntity(
                ex.getMessage(),
                "Unauthorized data",
                ex,
                HttpStatus.UNAUTHORIZED);
    }



    private ResponseEntity<Object> getObjectResponseEntity(String message, Object cause, RuntimeException ex, HttpStatus httpStatus) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", message);
        body.put("returned", cause);
        body.put("time", new Date().toString());

        return new ResponseEntity<>(body, httpStatus);
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

    @ExceptionHandler(DeviceNotFoundException.class)
    public ResponseEntity<Object> handleDeviceNotFoundException(DeviceNotFoundException exception, WebRequest request){
        Map<String, Object> body = new HashMap<>();
        body.put("message", exception.getMessage());
        body.put("returned", exception.getCause());
        body.put("time", new Date().toString());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
