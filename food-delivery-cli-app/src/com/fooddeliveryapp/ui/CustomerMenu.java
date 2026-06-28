package com.fooddeliveryapp.ui;

import com.fooddeliveryapp.controller.CustomerController;
import com.fooddeliveryapp.exceptions.CustomerExsistsException;
import com.fooddeliveryapp.model.Customer;
import com.fooddeliveryapp.repository.CustomerRepository;
import com.fooddeliveryapp.service.CustomerServiceImpl;
import com.fooddeliveryapp.util.Factory;

import java.util.Scanner;

public class CustomerMenu {
    private CustomerController customerController;

    public void displayCustomerMenu(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("               FOOD DELIVERY APP                             ");
            System.out.println("-------------------------------------------------------------");
            System.out.println();
            System.out.println("please select one option: ");
            System.out.println("-------------------------------------------------------------");
            System.out.println("1.Register(new customer) ");
            System.out.println("2.Login ( already exsisting customer)");
            System.out.println("3. View Menu");
            System.out.println("4. view Restaurants");
            System.out.println("5. Place Orders");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");
            System.out.println("--------------------------------------------------------");
            System.out.print("Enter your choice(1-7): ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayRegisterMenu();
                    break;
                case 7:
                    System.out.println("thankyou plz visit again");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. please enter choice between 1-7");
            }


        }
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
}
