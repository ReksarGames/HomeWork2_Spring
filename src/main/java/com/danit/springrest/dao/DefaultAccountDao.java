package com.danit.springrest.dao;

import com.danit.springrest.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class DefaultAccountDao implements AccountDao {
    private List<Account> accounts = new ArrayList<>();

    @Override
    public Account save(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public void delete(String accountId) {
        accounts.removeIf(account -> account.getId().equals(accountId));
    }

    @Override
    public void update(Account updatedAccount) {
        if (updatedAccount == null) {
            throw new IllegalArgumentException("Updated account cannot be null");
        }

        int index = findAccountIndexById(updatedAccount.getId());
        if (index != -1) {
            accounts.set(index, updatedAccount);
        }
    }


    @Override
    public Account getById(String accountId) {
        return accounts.stream()
                .filter(account -> account.getId().equals(accountId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accounts);
    }

    private int findAccountIndexById(Long accountId) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(accountId)) {
                return i;
            }
        }
        return -1;
    }
}