package com.luismata.mypnademo.account.core.ports.incoming;

import com.luismata.mypnademo.account.core.model.Account;

public interface CreateNewAccount {
    public Account createNewAccount(int accountOwnerCustomerId) ;//throws ProvidedCustomerIdNotFoundException;
}
