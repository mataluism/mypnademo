package com.luismata.mypnademo.customer.core.exceptions;

public class CustomerIdNotFoundException extends IllegalArgumentException {
    public CustomerIdNotFoundException(String message) {
        super(message);
    }
}
