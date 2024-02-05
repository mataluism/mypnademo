package com.luismata.mypnademo.customer.application.controllers;

import com.luismata.mypnademo.customer.core.model.Customer;
import com.luismata.mypnademo.customer.application.dto.CustomerDTO;
import com.luismata.mypnademo.customer.core.ports.incoming.CreateNewCustomer;
import com.luismata.mypnademo.customer.core.ports.incoming.GetCustomerById;
import com.luismata.mypnademo.customer.core.exceptions.InvalidNameProvidedException;
import com.luismata.mypnademo.customer.core.exceptions.CustomerIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CreateNewCustomer createNewCustomer;

    private final GetCustomerById getCustomerById;

    public CustomerController(CreateNewCustomer createNewCustomer, GetCustomerById getCustomerById) {
        this.createNewCustomer = createNewCustomer;
        this.getCustomerById = getCustomerById;
    }

    @GetMapping("/check-app")
    public String checkApp() {
        return "Hello from customer check-app";
    }

    @PostMapping("/create-new-customer")
    public int createNewCustomer(@RequestParam String customerName) {
        Customer newCustomer;

        try {
            newCustomer = createNewCustomer.createNewCustomer(customerName);
        } catch (InvalidNameProvidedException invalidNameProvidedException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, invalidNameProvidedException.getMessage());
        }

        return newCustomer.getCustomerId();
    }

    @GetMapping("/get-customer-by-id")
    public CustomerDTO getCustomerById(@RequestParam int customerIdToGet) {
        Customer customerById;
        try {
            customerById = getCustomerById.getCustomerById(customerIdToGet);
        } catch (CustomerIdNotFoundException providedCustomerIdNotFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, providedCustomerIdNotFoundException.getMessage());
        }

        return new CustomerDTO.CustomerDTOBuilder(customerById.getCustomerId()).withCustomerName(customerById.getCustomerName()).build();
    }

}
