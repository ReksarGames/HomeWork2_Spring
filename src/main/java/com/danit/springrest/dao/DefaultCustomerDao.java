//package com.danit.springrest.dao;
//
//import com.danit.springrest.enums.Currency;
//import com.danit.springrest.model.Account;
//import com.danit.springrest.model.Customer;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class DefaultCustomerDao implements CustomerRepository {
//    private List<Customer> customers = new ArrayList<>();
//
//    @Override
//    public void addCustomer(String name, String email, int age) {
//        customers.add(new Customer(name, email, age));
//    }
//
//    @Override
//    public void addCustomer(Customer customer) {
//        customers.add(customer);
//    }
//    @Override
//    public Customer createCustomer(Customer customer) {
//        customers.add(customer);
//        return customer;
//    }
//
//    @Override
//    public Customer infoById(Long id) {
//        return customers.stream()
//                .filter(customer -> customer.getId().equals(id))
//                .findFirst()
//                .orElse(null);
//    }
//
//    @Override
//    public void removeCustomer(Long id) {
//        customers.removeIf(customer -> customer.getId().equals(id));
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        return new ArrayList<>(customers);
//    }
//
//    @Override
//    public Account getNewlyCreatedAccount(Long customerId) {
//        Customer customer = customers.stream()
//                .filter(c -> c.getId().equals(customerId))
//                .findFirst()
//                .orElse(null);
//
//        if (customer != null && customer.getAccounts() != null && !customer.getAccounts().isEmpty()) {
//            return customer.getAccounts().get(customer.getAccounts().size() - 1);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public void replaceCustomer(Long id, Customer newData) {
//        Customer existingCustomer = customers.stream()
//                .filter(customer -> customer.getId().equals(id))
//                .findFirst()
//                .orElse(null);
//
//        if (existingCustomer != null && newData != null) {
//            existingCustomer.setName(newData.getName());
//            existingCustomer.setEmail(newData.getEmail());
//            existingCustomer.setAge(newData.getAge());
//        } else {
//            throw new IllegalArgumentException("Invalid user ID or data");
//        }
//    }
//
//    @Override
//    public Customer createCustomer(String name, String email, int age) {
//        Customer customer = new Customer(name, email, age); // null для ID, щоб база даних надавала йому ідентифікатор
//        addCustomer(customer);
//        return customer;
//    }
//
//    @Override
//    public void addNewAccount(Long customerId, String name, Currency currency) {
//        Customer customer = customers.stream()
//                .filter(customer1 -> customer1.getId().equals(customerId))
//                .findFirst()
//                .orElseThrow(() ->  new IllegalArgumentException("Customer not found with ID: " + customerId));
//
//        if (customer.getAccounts() == null) {
//            customer.setAccounts(new ArrayList<>());
//        }
//
//        Account newAccount = new Account(currency, customer);
//        customer.getAccounts().add(newAccount);
//    }
//
//    @Override
//    public void updateCustomerData(Long customerId, Customer newData) {
//        Customer customer = customers.stream()
//                .filter(customer1 -> customer1.getId().equals(customerId))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + customerId));
//
//        customer.setName(newData.getName());
//        customer.setEmail(newData.getEmail());
//        customer.setAge(newData.getAge());
//    }
//}
