package com.exam.exception;

public class UserFoundException extends Exception{
    public UserFoundException() {
        super("User with such username already exists in DB!!!");
    }
}
