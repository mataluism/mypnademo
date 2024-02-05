package com.luismata.mypnademo.account.core.exceptions;

public class ProvidedCustomerIdNotFoundException extends IllegalArgumentException {
    public ProvidedCustomerIdNotFoundException(String message) {
        super(message);
    }
}
