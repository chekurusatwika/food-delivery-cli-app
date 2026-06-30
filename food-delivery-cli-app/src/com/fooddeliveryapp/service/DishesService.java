package com.fooddeliveryapp.service;

import com.fooddeliveryapp.exceptions.DishNotFoundException;
import com.fooddeliveryapp.exceptions.DishesExsistsException;
import com.fooddeliveryapp.model.Dishes;

import java.util.List;

public interface DishesService {


    public List<Dishes> getAllDishes();
    public Dishes addDishes(Dishes dishes)throws DishesExsistsException;

    public Dishes getDishesById(String id) throws DishNotFoundException;
}
