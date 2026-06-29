package com.fooddeliveryapp.controller;

import com.fooddeliveryapp.exceptions.RestuarantExsistaException;
import com.fooddeliveryapp.model.Restaurant;
import com.fooddeliveryapp.service.RestaurantService;

public class RestaurantController {
    private RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    public Restaurant addRestaurant(Restaurant restaurant) throws RestuarantExsistaException {
         return this.restaurantService.addRestaurant(restaurant);
    }
}
