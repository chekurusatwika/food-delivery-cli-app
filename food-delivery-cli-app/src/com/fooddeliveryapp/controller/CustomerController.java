package com.fooddeliveryapp.controller;

import com.fooddeliveryapp.exceptions.CustomerExsistsException;
import com.fooddeliveryapp.model.Customer;
import com.fooddeliveryapp.service.CustomerServiceImpl;

public class CustomerController {

    // constructor injection for accessing customer service impl in customer controller
    private CustomerServiceImpl customerService; // reference variable that stores customerserviceimpl obj.
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    // add customer
    public Customer addCustomer(Customer customer) throws CustomerExsistsException {
        return customerService.addCustomer(customer);
    }

}
