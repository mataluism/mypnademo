package com.luismata.mypnademo.customer.infrastructure.adapters;

import com.luismata.mypnademo.customer.core.model.Customer;
import com.luismata.mypnademo.customer.core.ports.outgoing.CustomerRepository;
import com.luismata.mypnademo.customer.infrastructure.repositories.CustomerJPARepository;

import java.util.Optional;

public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerJPARepository customerRepository;

    public CustomerRepositoryAdapter(CustomerJPARepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(int customerIdToGet) {
        return customerRepository.findById(customerIdToGet);
    }
}
