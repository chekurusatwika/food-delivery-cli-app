package com.fooddeliveryapp.model;

import java.util.List;
import java.util.Objects;

public class Order {
    /*  add the following properties to Order class
String id, Customer customer, Restaurant restaurant, List<Dish> dishes, double price */
    private String orderId;
    private Customer customer;
    private Restaurant restaurant;
    private List<Dishes> dishes;
    private double price;

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Dishes> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dishes> dishes) {
        this.dishes = dishes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(price, order.price) == 0 && Objects.equals(orderId, order.orderId) && Objects.equals(customer, order.customer) && Objects.equals(restaurant, order.restaurant) && Objects.equals(dishes, order.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customer, restaurant, dishes, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customer=" + customer +
                ", restraunt=" + restaurant +
                ", dishes=" + dishes +
                ", price=" + price +
                '}';
    }
}
