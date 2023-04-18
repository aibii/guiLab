import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
// Importing several Java SQL packages
import daos.CityDao;
import daos.CountryDao;
import daos.LanguageDao;
import entities.City;
import entities.Country;
import entities.Database;
import entities.Language;
import view.MainFrame;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Declaring three lists for entities
        List<City> cityList;

        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "fishes12";

        try (Connection connection = Database.getDatabaseConnection();
        Statement statement = connection.createStatement();) {
            new MainFrame("cities").setVisible(true);

        // cityDao
        CityDao cityDao = new CityDao(connection);
        cityList = cityDao.findAll(); // Retrieves a list of all cities from the database
        
        System.out.println("Cities printed: ");
        for(City city: cityList) {
            System.out.println(city);   // Prints the list using a for-each loop
        }
    }
    catch(SQLException ex)
    {
        System.err.println("Exception " + ex.getMessage());
    }
}
}