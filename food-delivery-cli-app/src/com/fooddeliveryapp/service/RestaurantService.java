package com.fooddeliveryapp.service;

import com.fooddeliveryapp.exceptions.RestuarantExsistaException;
import com.fooddeliveryapp.model.Restaurant;

public interface RestaurantService {

    public Restaurant addRestaurant(Restaurant restaurant) throws RestuarantExsistaException;
}
