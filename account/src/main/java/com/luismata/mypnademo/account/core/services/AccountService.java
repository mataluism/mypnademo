package com.luismata.mypnademo.account.core.services;

import com.luismata.mypnademo.account.core.ports.incoming.CreateNewAccount;
import com.luismata.mypnademo.account.core.ports.outgoing.AccountRepository;
import com.luismata.mypnademo.account.core.model.Account;
import org.springframework.web.client.RestTemplate;

public class AccountService implements CreateNewAccount {

    private final AccountRepository accountRepository;

    private final RestTemplate restTemplate;

    public AccountService(AccountRepository accountRepository, RestTemplate restTemplate) {
        this.accountRepository = accountRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Account createNewAccount(int accountOwnerCustomerId) {

        String getCustomerByIdEndpoint = "http://localhost:8080/customer/get-customer-by-id?customerIdToGet={customerId}";
        //Customer customerById = restTemplate.getForObject(getCustomerByIdEndpoint, Customer.class, accountOwnerCustomerId);

//        if(customerById != null) {
//            Account newAccount = new Account(accountOwnerCustomerId);
//            accountRepository.saveAccount(newAccount);
//            return newAccount;
//        } else {
//            throw new ProvidedCustomerIdNotFoundException("Invalid customer id provided.");
//        }
        return new Account(accountOwnerCustomerId);
    }
}
