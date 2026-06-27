package com.fooddeliveryapp.service;

import com.fooddeliveryapp.exceptions.CustomerExsistsException;
import com.fooddeliveryapp.model.Customer;

public interface CustomerService {

   public Customer addCustomer(Customer customer) throws CustomerExsistsException;
}
