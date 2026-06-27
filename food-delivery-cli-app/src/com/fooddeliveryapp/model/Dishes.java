package com.fooddeliveryapp.model;

import java.util.Objects;

public class Dishes {
    /* add the following properties to Dish class
String id, String name, String description, double price */

    private String id;
    private String name;
    private String description;
    private double price;

    public Dishes() {
    }

    public String getId() {
        return id;
    }

    public Dishes setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dishes setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Dishes setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Dishes setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dishes dishes = (Dishes) o;
        return Double.compare(price, dishes.price) == 0 && Objects.equals(id, dishes.id) && Objects.equals(name, dishes.name) && Objects.equals(description, dishes.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
