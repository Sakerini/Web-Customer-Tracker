package com.sakerini.demo.rest;

import com.sakerini.demo.entity.Customer;
import com.sakerini.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        //try catch
        Customer customer = customerService.getCustomer(customerId);

        if (customer == null){
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }

        return customer;
    }

    // add mapping for post customers/ add new customers

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer) {

        // if the id is 0 than the DAO will insert as a new customer if else UPDATE
        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    // update customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {

        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    // delete customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
           throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }
        customerService.deleteCustomer(customerId);

        return "Deleted customer id - " + customerId;
    }

}
