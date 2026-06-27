package com.fooddeliveryapp.repository;

import com.fooddeliveryapp.model.Customer;
import com.fooddeliveryapp.util.CsvReader;

import java.util.List;

public class CustomerRepository {
    private List<Customer> customersList;

    public CustomerRepository() {
        CsvReader csvReader = new CsvReader();
        this.customersList = csvReader.readCustomersFromCsv();
    }

    public List<Customer> getAllCustomers(){
        return customersList;
    }
}
