package com.fooddeliveryapp.service;

import com.fooddeliveryapp.exceptions.RestaurantNotFoundException;
import com.fooddeliveryapp.exceptions.RestuarantExsistaException;
import com.fooddeliveryapp.model.Restaurant;
import com.fooddeliveryapp.repository.DishesRepository;
import com.fooddeliveryapp.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurantRepository;
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    //add restaurant
    @Override
    public Restaurant addRestaurant(Restaurant restaurant) throws RestuarantExsistaException {
        Optional<Restaurant> restaurantById = restaurantRepository.getRestaurantById(restaurant.getId());
        if(restaurantById.isPresent()){
            throw new RestuarantExsistaException("resturant already exsists with this id"+restaurant.getId());
        }
        return restaurantRepository.addRestaurant(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.getAllRestaurants();
    }

    @Override
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById = restaurantRepository.getRestaurantById(id);
        if(!restaurantById.isPresent()){
            throw new RestaurantNotFoundException("restaurant not found with this id"+id);
        }
        return restaurantById.get();
    }
}
