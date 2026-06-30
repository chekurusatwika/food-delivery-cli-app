package com.fooddeliveryapp.controller;

import com.fooddeliveryapp.exceptions.DishNotFoundException;
import com.fooddeliveryapp.exceptions.DishesExsistsException;
import com.fooddeliveryapp.model.Dishes;
import com.fooddeliveryapp.service.DishesServiceImpl;

import java.util.List;

public class DishesController {
    private DishesServiceImpl dishesService;
    public DishesController(DishesServiceImpl dishesService){

        this.dishesService = dishesService;
    }

    //get all dishes
    public List<Dishes> getAllDishes(){
        return dishesService.getAllDishes();
    }

    //add dishes
    public Dishes addDishes(Dishes dishes)throws DishesExsistsException {
        return  this.dishesService.addDishes(dishes);
    }
    //get dish by id
    public Dishes getDishesById(String id) throws DishNotFoundException {
        return this.dishesService.getDishesById(id);
    }

}

