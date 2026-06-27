package com.fooddeliveryapp.service;

import com.fooddeliveryapp.exceptions.CustomerExsistsException;
import com.fooddeliveryapp.model.Customer;
import com.fooddeliveryapp.repository.CustomerRepository;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer addCustomer(Customer customer) throws CustomerExsistsException {
        // if customer already exsists check by id,name,email.throws exception else add the customer to repository
        Optional<Customer> customerById = customerRepository.getCustomerById(customer.getId());
        if (customerById.isPresent()) {
            throw new CustomerExsistsException("customer already exsists with this id:"+customer.getId());
        }

        return this.customerRepository.addCustomer(customer);
    }
}
