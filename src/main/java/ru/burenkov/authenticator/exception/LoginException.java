package ru.burenkov.authenticator.exception;

public class LoginException extends RuntimeException{
    public LoginException(String message){
        super(message);
    }
    public LoginException(String message, Throwable cause){
        super(message,cause);
    }
}
