package com.luismata.mypnademo.account.core.ports.outgoing;

import com.luismata.mypnademo.account.core.model.Account;

public interface AccountRepository {
    Account saveAccount(Account account);
}
