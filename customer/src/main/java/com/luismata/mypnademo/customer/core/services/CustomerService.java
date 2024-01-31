package com.luismata.mypnademo.customer.core.services;

import com.luismata.mypnademo.customer.core.model.Customer;
import com.luismata.mypnademo.customer.core.ports.incoming.CreateNewCustomer;
import com.luismata.mypnademo.customer.core.ports.incoming.GetCustomerById;
import com.luismata.mypnademo.customer.core.ports.outgoing.CustomerRepository;
import com.luismata.mypnademo.customer.core.exceptions.InvalidNameProvidedException;
import com.luismata.mypnademo.customer.core.exceptions.ProvidedCustomerIdNotFoundException;

import java.util.Optional;

public class CustomerService implements CreateNewCustomer, GetCustomerById {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepositoryPort) {
        this.customerRepository = customerRepositoryPort;
    }

    @Override
    public Customer createNewCustomer(String newCustomerName) {
        if(newCustomerName.isBlank()) {
            throw new InvalidNameProvidedException("Provided name cannot be empty.");
        } else if (!isValidCustomerName(newCustomerName)) {
            throw new InvalidNameProvidedException("Invalid name provided.");
        }

        Customer newCustomer = new Customer(newCustomerName);

        return customerRepository.saveCustomer(newCustomer);
    }

    private boolean isValidCustomerName(String name) {
        return Customer.VALID_NAME_CHARACTERS_REGEX.matcher(name).matches();
    }

    @Override
    public Customer getCustomerById(int customerIdToGet) {
        Optional<Customer> customerById = customerRepository.getCustomerById(customerIdToGet);
        if(customerById.isPresent()) {
            return customerById.get();
        } else {
            throw new ProvidedCustomerIdNotFoundException("Customer with ID: " + customerIdToGet + " not found.");
        }
    }
}
