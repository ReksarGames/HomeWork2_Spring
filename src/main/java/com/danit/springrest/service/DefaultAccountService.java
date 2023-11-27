package com.danit.springrest.service;

import com.danit.springrest.dao.AccountDao;
import com.danit.springrest.enums.Currency;
import com.danit.springrest.model.Account;
import com.danit.springrest.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultAccountService implements AccountService{
    private final AccountDao accountDao;

    public DefaultAccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account createAccountForCustomer(Customer customer, Currency currency) {
        Account newAccount = new Account(currency, customer);
        accountDao.save(newAccount);
        return newAccount;
    }

    @Override
    public void deleteAccount(String accountId) {
        accountDao.delete(accountId);
    }

    @Override
    public void updateAccount(String accountId, Account updatedAccount) {
        accountDao.update(updatedAccount);
    }

    @Override
    public Account getAccountById(String accountId) {
        return accountDao.getById(accountId);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountDao.getAll();
    }
    @Override
    public void depositMoney(String accountId, double amount) {
        Account account = accountDao.getById(accountId);
        if (account != null) {
            double currentBalance = account.getBalance();
            double newBalance = currentBalance + amount;
            account.setBalance(newBalance);
            accountDao.update(account);
        } else {
            throw new IllegalArgumentException("Account not found with ID: " + accountId);
        }
    }

    @Override
    public void withdrawMoney(String accountId, double amount) {
        Account account = accountDao.getById(accountId);
        if (account != null) {
            double currentBalance = account.getBalance();
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                account.setBalance(newBalance);
                accountDao.update(account);
            } else {
                throw new IllegalArgumentException("Insufficient funds in account with ID: " + accountId);
            }
        } else {
            throw new IllegalArgumentException("Account not found with ID: " + accountId);
        }
    }

    @Override
    public void transferMoney(String fromAccountId, String toAccountId, double amount) {
        withdrawMoney(fromAccountId, amount);
        depositMoney(toAccountId, amount);
    }

}
