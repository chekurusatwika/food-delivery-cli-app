package com.fooddeliveryapp.util;

import com.fooddeliveryapp.model.Customer;
import com.fooddeliveryapp.model.Dishes;
import com.fooddeliveryapp.model.Restaurant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {

// read the data from csv files and store in list of objects

    public List<Customer> readCustomersFromCsv() {
        String line;
        List<Customer> customersList = new ArrayList<>();
        String csvFilePath = "C:\\Users\\Chekuru Satwika\\OneDrive\\Documents\\projects\\food-delivery\\food-delivery-cli-app\\food-delivery-cli-app\\data\\customers.csv";
        //io classes filereader and bufferReader
        // try with resources -> this will automatically close. when the execution completes
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // the headings will be stored . but we donot want that soo again br.readLine()
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Customer customer = new Customer();
                customer.setId(data[0])
                        .setName(data[1])
                        .setEmail(data[2])
                        .setPassword(data[3]);
                customersList.add(customer);
            }

        } catch (IOException e) {
            System.out.println("file not found" + csvFilePath);
            System.exit(0);
            e.printStackTrace();
        }
        return customersList;
    }

    //2. reading dishes from csv file
    /*----------------------------------------------------------------------------------------------------------------------------*/
    public List<Dishes> readDishesFromCsv() {
        String dishLine;
        List<Dishes> dishesList = new ArrayList<>();
        String dishCsvFilePath = "C:\\Users\\Chekuru Satwika\\OneDrive\\Documents\\projects\\food-delivery\\food-delivery-cli-app\\food-delivery-cli-app\\data\\dishes.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(dishCsvFilePath))) {
            br.readLine();
            while ((dishLine = br.readLine()) != null) {
                String[] data = dishLine.split(",");
                Dishes dishes = new Dishes();
                dishes.setId(data[0])
                        .setName(data[1])
                        .setDescription(data[2])
                        .setPrice(Double.parseDouble(data[3]));
                dishesList.add(dishes);

            }

        } catch (IOException ioe) {
            System.out.println("file not found" + dishCsvFilePath);
            System.exit(0);
            ioe.printStackTrace();
        }
        return dishesList;
    }

    //----------------------------------------------------------------------------------------------------------------------
    //3. read restaurants from csv
    public List<Restaurant> readRestaurantsFromCsv() {
        String restLine;
        List<Restaurant> restaurantList = new ArrayList<>();
        String restaurantcsvFilePath = "C:\\Users\\Chekuru Satwika\\OneDrive\\Documents\\projects\\food-delivery\\food-delivery-cli-app\\food-delivery-cli-app\\data\\restaurants.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(restaurantcsvFilePath))){
            br.readLine();
            while((restLine = br.readLine()) != null){
                String[] data = restLine.split(",");
                Restaurant restaurant = new Restaurant();
                restaurant.setId(data[0])
                        .setName(data[1])
                        .setAddress(data[2])
                        .setMenu(Arrays.asList(data[3].split(";")));
                restaurantList.add(restaurant);
            }

        }catch(IOException ioe){
            System.out.println("file not found" + restaurantcsvFilePath);
            System.exit(0);
            ioe.printStackTrace();
        }
        return restaurantList;
    }


}

