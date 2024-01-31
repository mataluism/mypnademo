package com.luismata.mypnademo.account.infrastructure.adapters;

import com.luismata.mypnademo.account.core.model.Account;
import com.luismata.mypnademo.account.core.ports.outgoing.AccountRepository;
import com.luismata.mypnademo.account.infrastructure.repositories.AccountJPARepository;

public class AccountRepositoryAdapter implements AccountRepository {

    private final AccountJPARepository accountRepository;

    public AccountRepositoryAdapter(AccountJPARepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
}
