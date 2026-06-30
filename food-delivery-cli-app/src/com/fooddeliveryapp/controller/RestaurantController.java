package com.fooddeliveryapp.controller;

import com.fooddeliveryapp.exceptions.RestaurantNotFoundException;
import com.fooddeliveryapp.exceptions.RestuarantExsistaException;
import com.fooddeliveryapp.model.Restaurant;
import com.fooddeliveryapp.service.RestaurantService;

import java.util.List;

public class RestaurantController {
    private RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    public Restaurant addRestaurant(Restaurant restaurant) throws RestuarantExsistaException {
         return this.restaurantService.addRestaurant(restaurant);
    }
    //get all restaurants
    public List<Restaurant> getAllRestaurants() {
        return this.restaurantService.getAllRestaurants();
    }
    //get restaurant by id
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
        return this.restaurantService.getRestaurantById(id);
    }
}
