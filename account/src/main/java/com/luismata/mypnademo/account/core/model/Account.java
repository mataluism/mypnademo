package com.luismata.mypnademo.account.core.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    private int accountOwnerCustomerId;
    private double balance;

    public Account(int accountOwnerCustomerId) {
        this.accountOwnerCustomerId = accountOwnerCustomerId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getAccountOwnerCustomerId() {
        return accountOwnerCustomerId;
    }

    public void setAccountOwnerCustomerId(int accountOwnerCustomerId) {
        this.accountOwnerCustomerId = accountOwnerCustomerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
