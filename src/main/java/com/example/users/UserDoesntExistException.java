package com.example.users;

import java.text.MessageFormat;

public class UserDoesntExistException extends RuntimeException {
    public UserDoesntExistException() {
        super("Usuario no registrado.");
    }
}