package com.fooddeliveryapp.util;

import com.fooddeliveryapp.controller.CustomerController;
import com.fooddeliveryapp.controller.DishesController;
import com.fooddeliveryapp.repository.CustomerRepository;
import com.fooddeliveryapp.repository.DishesRepository;
import com.fooddeliveryapp.service.CustomerService;
import com.fooddeliveryapp.service.CustomerServiceImpl;
import com.fooddeliveryapp.service.DishesServiceImpl;

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
    // csv reader obj
    public static CsvReader getCsvReader() {
        return new CsvReader();
    }
    //--------------------------------------------------------------------------------------------
    //for dish
    public static DishesRepository getDishesRepository() {
        return new DishesRepository();
    }
    public static DishesServiceImpl getDishesService() {
        return new DishesServiceImpl(getDishesRepository());
    }
    public static DishesController getDishesController() {
        return new DishesController(getDishesService());
    }
}
