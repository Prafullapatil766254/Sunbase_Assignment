package com.example.Model.CustomExceptions;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(){
        super();
    }

    public InvalidCredentialsException(String message){
        super(message);
    }
}
