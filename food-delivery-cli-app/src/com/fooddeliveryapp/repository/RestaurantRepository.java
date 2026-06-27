package com.fooddeliveryapp.repository;

import com.fooddeliveryapp.model.Restaurant;
import com.fooddeliveryapp.util.CsvReader;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    private List<Restaurant> restaurantList;

    public RestaurantRepository(){
        CsvReader csvReader = new CsvReader();
        this.restaurantList = csvReader.readRestaurantsFromCsv();
    }

    //1.get all resturant details
    public List<Restaurant> getAllRestaurants(){
        return restaurantList;
    }
}
