import com.fooddeliveryapp.repository.CustomerRepository;
import com.fooddeliveryapp.repository.DishesRepository;
import com.fooddeliveryapp.repository.RestaurantRepository;
import com.fooddeliveryapp.ui.CustomerMenu;
import com.fooddeliveryapp.util.CsvReader;

public class Main {
    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
       /* System.out.println(csvReader.readCustomersFromCsv());
        System.out.println(csvReader.readDishesFromCsv());
        System.out.println(csvReader.readRestaurantsFromCsv()); */
       /* CustomerRepository customerRepository = new CustomerRepository();
        System.out.println(customerRepository.getAllCustomers());

        DishesRepository dishesRepository = new DishesRepository();
        System.out.println(dishesRepository.getAllDishes());

        RestaurantRepository restaurantRepository = new RestaurantRepository();
        System.out.println(restaurantRepository.getAllRestaurants());*/
        CustomerMenu customerMenu = new CustomerMenu();
        customerMenu.displayCustomerMenu();

    }
}