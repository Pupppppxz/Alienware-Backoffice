package com.softwaretesting.alienware.exception;

public class InvalidBodyException extends Exception {
    public InvalidBodyException() {
        super("Invalid request body");
    }
}
