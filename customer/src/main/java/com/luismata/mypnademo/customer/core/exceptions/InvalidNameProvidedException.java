package com.luismata.mypnademo.customer.core.exceptions;

public class InvalidNameProvidedException extends IllegalArgumentException{
    public InvalidNameProvidedException(String errorMessage) {
        super(errorMessage);
    }
}
