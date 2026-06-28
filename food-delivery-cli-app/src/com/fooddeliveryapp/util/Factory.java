package com.fooddeliveryapp.util;

import com.fooddeliveryapp.controller.CustomerController;
import com.fooddeliveryapp.repository.CustomerRepository;
import com.fooddeliveryapp.service.CustomerService;
import com.fooddeliveryapp.service.CustomerServiceImpl;

public class Factory {
    // static methods
    public static CustomerRepository getCustomerRepository() {
        return new CustomerRepository();
    }

    //GET SERVICEIMPL
    public static CustomerServiceImpl getCustomerService() {
        return new CustomerServiceImpl(getCustomerRepository());
    }

    //controller
    public static CustomerController getCustomerController() {
        return new CustomerController(getCustomerService());
    }
}
