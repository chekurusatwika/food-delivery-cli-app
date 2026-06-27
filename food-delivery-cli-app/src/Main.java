import com.fooddeliveryapp.util.CsvReader;

public class Main {
    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        System.out.println(csvReader.readCustomersFromCsv());
    }
}