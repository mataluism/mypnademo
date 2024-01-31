package com.luismata.mypnademo.account.application.controllers;

import com.luismata.mypnademo.account.core.model.Account;
import com.luismata.mypnademo.account.core.ports.incoming.CreateNewAccount;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final CreateNewAccount createNewAccount;

    public AccountController(CreateNewAccount createNewAccount) {
        this.createNewAccount = createNewAccount;
    }

    @GetMapping("/check-app")
    public String checkApp() {
        return "Hello from check-app";
    }

    @PostMapping("/create-new-account")
    public int createNewAccount(@RequestParam int customerId) {
        Account account = null;
//        try {
            account = createNewAccount.createNewAccount(customerId);
//        } catch (ProvidedCustomerIdNotFoundException exc) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, exc.getMessage(), exc);
//        }
        return account.getAccountId();
    }
}
