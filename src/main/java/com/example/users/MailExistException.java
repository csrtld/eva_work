package com.example.users;

import java.text.MessageFormat;

public class MailExistException extends RuntimeException {
    public MailExistException(String mail) {
        super(MessageFormat.format("El correo ''{0}'' ya fue registrado.", mail));
    }
}