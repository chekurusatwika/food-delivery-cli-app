package com.fooddeliveryapp.service;

import com.fooddeliveryapp.exceptions.RestuarantExsistaException;
import com.fooddeliveryapp.model.Restaurant;
import com.fooddeliveryapp.repository.DishesRepository;
import com.fooddeliveryapp.repository.RestaurantRepository;

import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurantRepository;
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    @Override
    public Restaurant addRestaurant(Restaurant restaurant) throws RestuarantExsistaException {
        Optional<Restaurant> restaurantById = restaurantRepository.getRestaurantById(restaurant.getId());
        if(restaurantById.isPresent()){
            throw new RestuarantExsistaException("resturant already exsists with this id"+restaurant.getId());
        }
        return restaurantRepository.addRestaurant(restaurant);
    }
}
