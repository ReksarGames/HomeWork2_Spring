package com.danit.springrest.service;

import com.danit.springrest.enums.Currency;
import com.danit.springrest.model.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Page<Customer> getAllCustomers(int page, int size);
    Customer getCustomerById(Long customerId);
    Customer addCustomer(Customer customer);
    Customer createCustomer(String name, String email, int age);
    Customer createCustomer(Customer customer);
    void updateCustomer(Long customerId, Customer updatedCustomer);
    void deleteCustomer(Long customerId);
}
