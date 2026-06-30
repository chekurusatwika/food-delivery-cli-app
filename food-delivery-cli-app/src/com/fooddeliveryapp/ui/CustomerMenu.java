package com.fooddeliveryapp.ui;

import com.fooddeliveryapp.controller.CustomerController;
import com.fooddeliveryapp.controller.DishesController;
import com.fooddeliveryapp.controller.RestaurantController;
import com.fooddeliveryapp.exceptions.CustomerExsistsException;
import com.fooddeliveryapp.exceptions.DishesExsistsException;
import com.fooddeliveryapp.exceptions.RestuarantExsistaException;
import com.fooddeliveryapp.model.Customer;
import com.fooddeliveryapp.model.Dishes;
import com.fooddeliveryapp.model.Restaurant;
import com.fooddeliveryapp.repository.CustomerRepository;
import com.fooddeliveryapp.repository.DishesRepository;
import com.fooddeliveryapp.service.*;
import com.fooddeliveryapp.util.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    private CustomerController customerController;

    public void displayCustomerMenu(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            /*System.out.println("-------------------------------------------------------------");
            System.out.println("               FOOD DELIVERY APP                             ");
            System.out.println("-------------------------------------------------------------");*/
            displayMenuHeader("WELCOME TO FOOD DELIVERY APP");
            System.out.println();
            System.out.println("please select one option: ");
            System.out.println("-------------------------------------------------------------");
            System.out.println("1.Register(new customer) ");
            System.out.println("2.Login ( already exsisting customer)");
            System.out.println("3. View Dishes Menu");
            System.out.println("4. view Restaurants");
            System.out.println("5.Add new Dish");
            System.out.println("6.Add new Restaurants");
            System.out.println("7. Place Orders");
            System.out.println("8. View Orders");
            System.out.println("9. Exit");
            System.out.println("--------------------------------------------------------");
            System.out.print("Enter your choice(1-7): ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayRegisterMenu();
                    break;
                case 3:
                    displayDishesList() ;
                    break;
                case 4:
                    displayRestaurantsList();
                    break;
                case 5:
                    displayAddDishMenu();
                    break;
                case 6:
                    displayAddRestaurantMenu();
                    break;
                case 9:
                    System.out.println("thankyou plz visit again");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. please enter choice between 1-7");
            }


        }
    }

    private void displayAddRestaurantMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("please register new Restaurant");
        System.out.println("please enter restaurant ID:");
        String restaurantID = sc.nextLine();
        System.out.println("please enter restaurant name:");
        String restaurantName = sc.nextLine();
        System.out.println("please enter restaurant address:");
        String restaurantAddress = sc.nextLine();
        System.out.println("please enter restaurant Menu:");
        String restaurantMenu = sc.nextLine();
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantID)
                    .setName(restaurantName)
                .setAddress(restaurantAddress)
                .setMenu(Arrays.asList(restaurantMenu.split(",")));
        RestaurantController restaurantController = Factory.getRestaurantController();
        try{
            restaurantController.addRestaurant(restaurant);
            if(restaurant!= null){
                System.out.println("restaurant has been added successfully");
                System.out.println("Restaurant ID: " + restaurant.getId());
                System.out.println("Restaurant Name: " + restaurant.getName());
                System.out.println("Restaurant Address: " + restaurant.getAddress());
                System.out.println("Restaurant Menu: " + restaurant.getMenu());
            }else{
                System.out.println("restaurant is null add again");
                displayAddRestaurantMenu();
            }
        }catch(RestuarantExsistaException re){
            System.out.println(re.getMessage());
            displayAddRestaurantMenu();
        }
    }

    private void displayAddDishMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add new dish to the Menu");
        System.out.println("Enter dish ID: ");
        String dishId = sc.nextLine();
        System.out.println("Enter dish name: ");
        String dishName = sc.nextLine();
        System.out.println("Enter dish description: ");
        String dishDescription = sc.nextLine();
        System.out.println("Enter dish price: ");
        double dishPrice = sc.nextDouble();
        Dishes dish = new Dishes();
        dish.setId(dishId)
            .setName(dishName)
            .setDescription(dishDescription)
            .setPrice(dishPrice);
        DishesController dishesController = Factory.getDishesController();
        try{
            dishesController.addDishes(dish);
            if(dish != null) {
                System.out.println("Dish added successfully");
                System.out.println("dish ID :" + dish.getId());
                System.out.println("dish name :" + dish.getName());
                System.out.println("dish description :" + dish.getDescription());
                System.out.println("dish price :" + dish.getPrice());
            }else{
                System.out.println("dish is null please enter the data");
                displayRegisterMenu();

            }
        }catch(DishesExsistsException de){
            System.out.println(de.getMessage());
            System.out.println("some internal error please try again with main menu");
            displayAddDishMenu();
        }

    }

    private void displayRestaurantsList() {
        RestaurantController restaurantController = Factory.getRestaurantController();
        List<Restaurant> restaurantList = restaurantController.getAllRestaurants();
        displayMenuHeader("Restaurant List Menu");
        String dashLines = new String(new char[150]).replace("\0", "-");
        System.out.format("%-10s %-30s %-80s %-10s\n","Id","Name","Address","Menu");
        System.out.println(dashLines);
        restaurantList.forEach(restaurant -> {
            System.out.printf("%-10s %-30s %-80s %-10s\n",restaurant.getId(),restaurant.getName(),restaurant.getAddress(),restaurant.getMenu());
        });

    }

    private void displayDishesList() {

        /*DishesRepository dishesRepository = new DishesRepository();
        DishesServiceImpl dishesService = new DishesServiceImpl(dishesRepository);
        DishesController dishesController = new DishesController(dishesService);*/
        DishesController dishesController = Factory.getDishesController();
        List<Dishes> dishesList = dishesController.getAllDishes();
        //System.out.println(dishesController.getAllDishes());
        String dashLines = new String(new char[150]).replace("\0", "-");
        displayMenuHeader("Menu Items");
        System.out.format("%-10s %-30s %-80s %-10s\n","Id","Name","Description","Price");
        System.out.println(dashLines);
        dishesList.forEach(dishes -> {
            System.out.printf("%-10s %-30s %-80s %-10s\n",dishes.getId(),dishes.getName(),dishes.getDescription(),String.format("$%.2f",dishes.getPrice()));
        });
    }

    public void displayRegisterMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your id: ");
        String id = sc.nextLine();
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your email:");
        String email = sc.nextLine();
        /* Console console = System.Console();
        System.out.println("Console: "+console)
        Char[] passwordArray = console.readPassword("enter pasword(invisible)");
        String password = String.valueOf(passwordArray);
         */
        System.out.println("Enter your password:");
        String password = sc.nextLine();
        Customer customer = new Customer()
                .setId(id)
                .setName(name)
                .setEmail(email)
                .setPassword(password);
       /* CustomerRepository customerRepository = new CustomerRepository();
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
        customerController = new CustomerController(customerService);*/

        CustomerController customerController  = Factory.getCustomerController();
        try {
            customerController.addCustomer(customer);
            if( customer != null ) {
                System.out.println("Your customer has been registered(added) successfully.");
                System.out.println("customer ID : " + id);
                System.out.println("customer name : " + name);
                System.out.println("customer email : " + email);
                System.out.println("customer password : " + password);
            }else{
                System.out.println("some thing went wrong please try again.");
                displayCustomerMenu();
            }
        }catch(CustomerExsistsException e){
            System.out.println(e.getMessage());
            System.out.println("please login");
            displayCustomerMenu();

        }
    }
    public void displayMenuHeader(String menuHeader){
        // u have a string constructor which has char arr which contains\0 by default
        String dashLines = new String(new char [150]).replace("\0", "-");
        System.out.println(dashLines);
        String spaces = new String(new char[70]).replace("\0", " ");
        System.out.format("%-70s %-10s %-70s \n", spaces,menuHeader,spaces);
        //here "-" is for left alignment
        System.out.println(dashLines);


    }
}
