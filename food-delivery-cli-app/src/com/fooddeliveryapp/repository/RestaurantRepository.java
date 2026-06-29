package com.fooddeliveryapp.repository;

import com.fooddeliveryapp.model.Restaurant;
import com.fooddeliveryapp.util.CsvReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    //1.add resturant
    public Restaurant addRestaurant(Restaurant restaurant){
        this.restaurantList.add(restaurant);
        return restaurant;
    }

    //2. get by resturantId
    public Optional<Restaurant> getRestaurantById(String id){
         return restaurantList.stream().filter(restaurant -> restaurant.getId().equals(id)).findFirst();
    }
}
