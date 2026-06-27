package com.fooddeliveryapp.exceptions;

public class CustomerExsistsException extends RuntimeException{
    public CustomerExsistsException(String message){
        super(message);
    }
}
