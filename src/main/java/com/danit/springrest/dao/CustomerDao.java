package com.danit.springrest.dao;

import com.danit.springrest.enums.Currency;
import com.danit.springrest.model.Account;
import com.danit.springrest.model.Customer;

import java.util.List;

public interface CustomerDao {
    void addCustomer(String name, String email, int age);
    void addCustomer(Customer customer);
    Customer infoById(Long id);
    void removeCustomer(Long id);
    Customer createCustomer(String name, String email, int age);
    void replaceCustomer(Long id,Customer newData);
    void addNewAccount(Long id, String name, Currency currency);
    void updateCustomerData(Long customerId, Customer newData);
    List<Customer> findAll();
    Account getNewlyCreatedAccount(Long customerId);

}