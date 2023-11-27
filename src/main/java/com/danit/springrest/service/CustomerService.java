package com.danit.springrest.service;

import com.danit.springrest.enums.Currency;
import com.danit.springrest.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long customerId);
    Customer addCustomer(Customer customer);
    Customer createCustomer(String name, String email, int age);

    void updateCustomer(Long customerId, Customer updatedCustomer);
    void deleteCustomer(Long customerId);
    void createAccountForCustomer(Long customerId, String name, Currency currency);
}
