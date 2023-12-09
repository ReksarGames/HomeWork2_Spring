package com.danit.springrest.service;

import com.danit.springrest.dao.AccountRepository;
import com.danit.springrest.enums.Currency;
import com.danit.springrest.model.Account;
import com.danit.springrest.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultAccountService implements AccountService{
    private final AccountRepository accountRepository;

    public DefaultAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccountForCustomer(Customer customer, Currency currency) {
        Account newAccount = new Account(currency, customer);
        accountRepository.save(newAccount);
        return newAccount;
    }
    @Override
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }
    @Override
    public void deleteAccount(String accountId) {
        accountRepository.deleteById(Long.valueOf(accountId));
    }

    @Override
    public void updateAccount(String accountId, Account updatedAccount) {
        if (accountRepository.existsById(Long.valueOf(accountId))) {
            updatedAccount.setId(Long.valueOf(accountId));
            accountRepository.save(updatedAccount);
        } else {
            throw new IllegalArgumentException("Account not found with ID: " + accountId);
        }
    }

    @Override
    public Account getAccountById(String accountId) {
        return accountRepository.findById(Long.valueOf(accountId)).orElse(null);
    }
    @Override
    public Page<Account> getAllAccounts(PageRequest pageRequest) {
        return accountRepository.findAll(pageRequest);
    }
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    @Override
    public void depositMoney(String accountId, double amount) {
        Account account = accountRepository.findById(Long.valueOf(accountId)).orElse(null);
        if (account != null) {
            double currentBalance = account.getBalance();
            double newBalance = currentBalance + amount;
            account.setBalance(newBalance);
            accountRepository.save(account);
        } else {
            throw new IllegalArgumentException("Account not found with ID: " + accountId);
        }
    }

    @Override
    public void withdrawMoney(String accountId, double amount) {
        Account account = accountRepository.findById(Long.valueOf(accountId)).orElse(null);
        if (account != null) {
            double currentBalance = account.getBalance();
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                account.setBalance(newBalance);
                accountRepository.save(account);
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
