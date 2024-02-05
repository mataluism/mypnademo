package com.luismata.mypnademo.account.core.services;

import com.luismata.mypnademo.account.core.exceptions.ProvidedCustomerIdNotFoundException;
import com.luismata.mypnademo.account.core.ports.incoming.CreateNewAccount;
import com.luismata.mypnademo.account.core.ports.outgoing.AccountRepository;
import com.luismata.mypnademo.account.core.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.client.RestTemplate;

public class AccountService implements CreateNewAccount {

    private final AccountRepository accountRepository;

    private final JmsTemplate jmsTemplate;

    @Value("${activemq.destination}")
    private String destination;

    public AccountService(AccountRepository accountRepository, JmsTemplate jmsTemplate) {
        this.accountRepository = accountRepository;
        this.jmsTemplate = jmsTemplate;
    }


    @Override
    public Account createNewAccount(int accountOwnerCustomerId) {

//        // With rest template:
//        String getCustomerByIdEndpoint = "http://localhost:8080/customer/get-customer-by-id?customerIdToGet={customerId}";
//        Customer customerById = restTemplate.getForObject(getCustomerByIdEndpoint, Customer.class, accountOwnerCustomerId);

        // Using ActiveMQ
        jmsTemplate.convertAndSend(destination, "Customer id to search: " + accountOwnerCustomerId);

        boolean customerById= true;

        // TODO LM: change this back
        if(customerById) {
            Account newAccount = new Account(accountOwnerCustomerId);
            accountRepository.saveAccount(newAccount);
            return newAccount;
        } else {
            throw new ProvidedCustomerIdNotFoundException("Invalid customer id provided.");
        }
//        return new Account(accountOwnerCustomerId);
    }
}
