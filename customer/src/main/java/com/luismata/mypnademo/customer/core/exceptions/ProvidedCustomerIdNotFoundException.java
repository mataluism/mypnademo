package com.luismata.mypnademo.customer.core.exceptions;

public class ProvidedCustomerIdNotFoundException extends IllegalArgumentException {
    public ProvidedCustomerIdNotFoundException(String message) {
        super(message);
    }
}
