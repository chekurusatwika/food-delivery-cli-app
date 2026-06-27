package com.fooddeliveryapp.util;

import com.fooddeliveryapp.model.Customer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

// read the data from csv files and store in list of objects

    public List<Customer> readCustomersFromCsv()  {
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
            System.out.println("file not found"+csvFilePath);
            System.exit(0);
            e.printStackTrace();
        }
        return customersList;
    }
}

