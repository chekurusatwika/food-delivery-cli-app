package com.fooddeliveryapp.service;

import com.fooddeliveryapp.exceptions.RestaurantNotFoundException;
import com.fooddeliveryapp.exceptions.RestuarantExsistaException;
import com.fooddeliveryapp.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    public Restaurant addRestaurant(Restaurant restaurant) throws RestuarantExsistaException;
    // get all restuarants
    public List<Restaurant> getAllRestaurants();
    // get restuarant by id
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException;
}
