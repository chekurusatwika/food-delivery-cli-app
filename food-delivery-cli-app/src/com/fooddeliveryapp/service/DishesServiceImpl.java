package com.fooddeliveryapp.service;

import com.fooddeliveryapp.exceptions.DishNotFoundException;
import com.fooddeliveryapp.exceptions.DishesExsistsException;
import com.fooddeliveryapp.model.Dishes;
import com.fooddeliveryapp.repository.DishesRepository;

import java.util.List;
import java.util.Optional;

public class DishesServiceImpl implements DishesService {
    private DishesRepository dishesRepository;

    public DishesServiceImpl(DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    @Override
    public List<Dishes> getAllDishes() {
        return dishesRepository.getAllDishes();
    }

    @Override
    public Dishes addDishes(Dishes dishes) throws DishesExsistsException {
        Optional<Dishes> dishById = dishesRepository.getDishById(dishes.getId());
        if(dishById.isPresent()){
            throw new DishesExsistsException("this dish already exsists with id"+dishes.getId());
        }
        return this.dishesRepository.addDish(dishes);
    }


    @Override
    public Dishes getDishesById(String id) throws DishNotFoundException {
        Optional<Dishes> dishById = dishesRepository.getDishById(id);
        if(!dishById.isPresent()){
            throw new DishNotFoundException("this dish does not exist"+id);
        }
        return  dishById.get(); // watever the dish with the given id that  obj will be printed
    }
}
