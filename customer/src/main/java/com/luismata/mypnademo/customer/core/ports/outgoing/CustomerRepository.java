package com.luismata.mypnademo.customer.core.ports.outgoing;

import com.luismata.mypnademo.customer.core.model.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Customer saveCustomer(Customer customer);

    Optional<Customer> getCustomerById(int customerIdToGet);
}
