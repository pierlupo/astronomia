package com.infrastructure.exception;

public class NotFoundException extends Exception {

    public NotFoundException() {
        super("Not found exception");
    }
}
