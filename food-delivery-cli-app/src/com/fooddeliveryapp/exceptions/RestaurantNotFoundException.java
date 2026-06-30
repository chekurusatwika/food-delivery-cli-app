package com.fooddeliveryapp.exceptions;

public class RestaurantNotFoundException  extends Exception{
    public RestaurantNotFoundException(String message){
        super(message);
    }

}
