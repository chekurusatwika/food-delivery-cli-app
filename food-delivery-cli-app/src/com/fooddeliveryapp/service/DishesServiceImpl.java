package com.fooddeliveryapp.service;

import com.fooddeliveryapp.exceptions.DishesExsistsException;
import com.fooddeliveryapp.model.Dishes;
import com.fooddeliveryapp.repository.DishesRepository;

import java.util.Optional;

public class DishesServiceImpl implements DishesService {
    private DishesRepository dishesRepository;

    public DishesServiceImpl(DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    @Override
    public Dishes addDishes(Dishes dishes) throws DishesExsistsException {
        Optional<Dishes> dishById = dishesRepository.getDishById(dishes.getId());
        if(dishById.isPresent()){
            throw new DishesExsistsException("this dish already exsists with id"+dishes.getId());
        }
        return this.dishesRepository.addDish(dishes);
    }
}
