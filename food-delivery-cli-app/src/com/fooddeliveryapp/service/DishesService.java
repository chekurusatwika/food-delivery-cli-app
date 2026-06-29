package com.fooddeliveryapp.service;

import com.fooddeliveryapp.exceptions.DishesExsistsException;
import com.fooddeliveryapp.model.Dishes;

public interface DishesService {

    public Dishes addDishes(Dishes dishes)throws DishesExsistsException;
}
