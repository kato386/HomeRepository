package com.example.hw1.exception;

public class HomeNotFoundException extends RuntimeException {
    public HomeNotFoundException(String message){
        super(message);
    }
}
