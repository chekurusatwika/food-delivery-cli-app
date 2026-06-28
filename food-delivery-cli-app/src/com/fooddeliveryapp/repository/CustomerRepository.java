package com.fooddeliveryapp.repository;

import com.fooddeliveryapp.model.Customer;
import com.fooddeliveryapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private List<Customer> customersList;

    public CustomerRepository() {
        CsvReader csvReader = new CsvReader();
        this.customersList = csvReader.readCustomersFromCsv();
    }
    // get all customers
    public List<Customer> getAllCustomers(){

        return customersList;
    }
    //CURD OPERATIONS

    //1.add customer
    public Customer addCustomer(Customer customer){
        this.customersList.add(customer);
        return customer;
    }

    //2.get customer by id
    public Optional<Customer> getCustomerById(String id){
         return customersList.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }
}
