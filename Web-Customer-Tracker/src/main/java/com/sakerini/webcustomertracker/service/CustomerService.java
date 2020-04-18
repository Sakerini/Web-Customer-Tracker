package com.sakerini.webcustomertracker.service;

import com.sakerini.webcustomertracker.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);

    List<Customer> searchCustomer(String theSearchName);
}
