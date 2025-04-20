package com.example.hw1.exception;

public class InvalidHomeDataException extends RuntimeException{
    public InvalidHomeDataException(String message) {
        super(message);
    }
}
