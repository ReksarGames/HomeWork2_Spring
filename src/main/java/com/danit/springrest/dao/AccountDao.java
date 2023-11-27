package com.danit.springrest.dao;

import com.danit.springrest.model.Account;

import java.util.List;

public interface AccountDao {
    Account save(Account account);
    void delete(String accountId);
    void update(Account updatedAccount);
    Account getById(String accountId);
    List<Account> getAll();

}
