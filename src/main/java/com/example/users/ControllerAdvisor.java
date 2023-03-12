package com.example.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserDoesntExistException.class)
    protected ResponseEntity<Object> handleUserDoesntExistException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Error(ex.getMessage()));
    }

    @ExceptionHandler({MailExistException.class, IllegalArgumentException.class})
    protected ResponseEntity<Object> handleMailExistException(Exception ex) {
        return ResponseEntity
                .badRequest()
                .body(new Error(ex.getMessage()));
    }
}
