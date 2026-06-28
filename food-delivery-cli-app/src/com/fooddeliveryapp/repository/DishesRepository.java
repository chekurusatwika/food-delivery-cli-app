package com.fooddeliveryapp.repository;

import com.fooddeliveryapp.model.Dishes;
import com.fooddeliveryapp.util.CsvReader;

import java.util.List;

public class DishesRepository {
    private List<Dishes> dishesList;

    public DishesRepository(){
        CsvReader csvReader = new CsvReader();
        this.dishesList = csvReader.readDishesFromCsv();

    }

    //get all the dishes
    public List<Dishes> getAllDishes(){
        return dishesList;
    }

    //1.add dish
    public Dishes addDish(Dishes dish){
        this.dishesList.add(dish);
        return dish;
    }
}
