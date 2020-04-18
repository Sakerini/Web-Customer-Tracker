package com.sakerini.webcustomertracker.dao;

import com.sakerini.webcustomertracker.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);

    List<Customer> searchCustomer(String theSearchName);
}
