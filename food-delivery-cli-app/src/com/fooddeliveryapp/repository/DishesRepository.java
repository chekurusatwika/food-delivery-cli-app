package com.fooddeliveryapp.repository;

import com.fooddeliveryapp.model.Dishes;
import com.fooddeliveryapp.util.CsvReader;
import com.fooddeliveryapp.util.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DishesRepository {
    private List<Dishes> dishesList;

    public DishesRepository(){
        /*CsvReader csvReader = new CsvReader();
        this.dishesList = csvReader.readDishesFromCsv();*/
        this.dishesList = Factory.getCsvReader().readDishesFromCsv(); // here the getcsvreader method gives csvreadr obj
        // and then on that obj perfrom readdishes from csv method

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

    //2.get dishes by id
    public Optional<Dishes> getDishById(String id){
        return dishesList.stream().filter(dish -> dish.getId().equals(id)).findFirst();
    }
}
