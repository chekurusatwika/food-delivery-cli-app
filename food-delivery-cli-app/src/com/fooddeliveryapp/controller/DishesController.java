package com.fooddeliveryapp.controller;

import com.fooddeliveryapp.exceptions.DishesExsistsException;
import com.fooddeliveryapp.model.Dishes;
import com.fooddeliveryapp.service.DishesServiceImpl;

public class DishesController {
    private DishesServiceImpl dishesService;
    public DishesController(DishesServiceImpl dishesService){
        this.dishesService = dishesService;
    }

    //add dishes
    public Dishes addDishes(Dishes dishes)throws DishesExsistsException {
        return  this.dishesService.addDishes(dishes);
    }
}
