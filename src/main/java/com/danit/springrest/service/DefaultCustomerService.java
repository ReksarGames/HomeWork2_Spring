package com.danit.springrest.service;

import com.danit.springrest.dao.CustomerDao;
import com.danit.springrest.enums.Currency;
import com.danit.springrest.model.Account;
import com.danit.springrest.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Service
public class DefaultCustomerService implements CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public DefaultCustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerDao.infoById(customerId);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customerDao.addCustomer(customer.getName(), customer.getEmail(), customer.getAge());
        return customer;
    }
    @Override
    public Customer createCustomer(String name, String email, int age) {
        return customerDao.createCustomer(name, email, age);
    }
    @Override
    public void updateCustomer(Long customerId, Customer updatedCustomer) {
        customerDao.replaceCustomer(customerId, updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerDao.removeCustomer(customerId);
    }

    @Override
    public void createAccountForCustomer(Long customerId, String name, Currency currency) {
        customerDao.addNewAccount(customerId, name, currency);
    }
    private Long generateUniqueId() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
