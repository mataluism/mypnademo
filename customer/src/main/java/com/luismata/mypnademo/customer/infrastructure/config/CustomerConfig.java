package com.luismata.mypnademo.customer.infrastructure.config;

import com.luismata.mypnademo.customer.core.ports.incoming.CreateNewCustomer;
import com.luismata.mypnademo.customer.core.ports.outgoing.CustomerRepository;
import com.luismata.mypnademo.customer.core.services.CustomerService;
import com.luismata.mypnademo.customer.infrastructure.adapters.CustomerRepositoryAdapter;
import com.luismata.mypnademo.customer.infrastructure.repositories.CustomerJPARepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    public CustomerRepository customerRepositoryPort(CustomerJPARepository customerRepository){
        return new CustomerRepositoryAdapter(customerRepository);
    }

    @Bean
    public CreateNewCustomer createNewCustomerPort(CustomerRepository customerRepositoryPort) {
        return new CustomerService(customerRepositoryPort);
    }

}
