package com.danit.springrest.service;

import com.danit.springrest.enums.Currency;
import com.danit.springrest.model.Account;
import com.danit.springrest.model.Customer;

import java.util.List;

public interface AccountService {
    Account createAccountForCustomer(Customer customer, Currency currency);
    void deleteAccount(String accountId);
    void updateAccount(String accountId, Account updatedAccount);
    Account getAccountById(String accountId);
    List<Account> getAllAccounts();
    Account createAccount(Account account);
    void depositMoney(String accountId, double amount);
    void withdrawMoney(String accountId, double amount);
    void transferMoney(String fromAccountId, String toAccountId, double amount);

}
