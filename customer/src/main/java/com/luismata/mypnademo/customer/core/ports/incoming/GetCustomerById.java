package com.luismata.mypnademo.customer.core.ports.incoming;

import com.luismata.mypnademo.customer.core.model.Customer;

public interface GetCustomerById {
    Customer getCustomerById(int customerIdToGet);
}
