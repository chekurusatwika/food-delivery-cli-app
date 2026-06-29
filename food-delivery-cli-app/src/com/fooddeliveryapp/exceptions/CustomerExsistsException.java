package com.fooddeliveryapp.exceptions;

public class CustomerExsistsException extends Exception{
    public CustomerExsistsException(String message){
        super(message);
    }
}
