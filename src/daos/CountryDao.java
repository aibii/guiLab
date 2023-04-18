package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Country;

public class CountryDao implements Dao<Country,String> {
    Connection connection;

    public CountryDao(Connection connection) {
        this.connection = connection;
    }

    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();

        try(Statement statement = connection.createStatement())
        {
            ResultSet result = statement.executeQuery("SELECT * FROM country");
            while(result.next())
            {
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setName(result.getString("Name"));
                country.setPopulation(result.getInt("Population"));
                country.setSurfaceArea(result.getDouble("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setLifeExpectancy(result.getDouble("LifeExpectancy"));
                country.setGnp(result.getDouble("GNP"));
                country.setGnpOld(result.getDouble("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
                countries.add(country);
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        return countries;
    }

    public Country findById(String code) {
        Country country = new Country();
        String select = "SELECT * FROM country WHERE Code=?";

        try(PreparedStatement ps = connection.prepareStatement(select);){
            ps.setString(1, code);
            ResultSet result = ps.executeQuery();

            if(result.next())
            {
                country.setCode(result.getString("Code"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setName(result.getString("Name"));
                country.setPopulation(result.getInt("Population"));
                country.setSurfaceArea(result.getDouble("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setLifeExpectancy(result.getDouble("LifeExpectancy"));
                country.setGnp(result.getDouble("GNP"));
                country.setGnpOld(result.getDouble("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return country;
    }

    public void insert(Country country) {
        try(Statement statement = connection.createStatement())
        {
            String insert = "INSERT INTO country VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS); //??
            ps.setString(1, country.getCode());
            ps.setString(2, country.getName());
            ps.setString(3, country.getContinent());
            ps.setString(4, country.getRegion());
            ps.setDouble(5, country.getSurfaceArea());
            ps.setInt(6, country.getIndepYear());
            ps.setInt(7, country.getPopulation());
            ps.setDouble(8, country.getLifeExpectancy());
            ps.setDouble(9, country.getGnp());
            ps.setDouble(10, country.getGnpOld());
            ps.setString(11, country.getLocalName());
            ps.setString(12, country.getGovernmentForm());
            ps.setString(13, country.getHeadOfState());
            ps.setInt(14, country.getCapital());
            ps.setString(15, country.getCode2());
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public Boolean update(Country country) {
        Boolean success = true;
        String update = "UPDATE country SET population=? WHERE Code=?";

        try(PreparedStatement ps = connection.prepareStatement(update);){
            ps.setInt(1, country.getPopulation());
            ps.setString(2, country.getCode());
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            success = false;
        }
        return success;
    }

    public Boolean delete(String code) {
        Boolean success = false;
        String delete = "DELETE FROM country WHERE Code=?";

        try(PreparedStatement ps = connection.prepareStatement(delete)){
            ps.setString(1, code);

            if(ps.executeUpdate() != 0)
            {
                success = true;
            }

        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        return success;
    }

    public Country findByName(String name)
    {
        Country country = new Country();
        String select = "SELECT * FROM country WHERE name=?";

        try(PreparedStatement ps = connection.prepareStatement(select);){
            ps.setString(1, name);
            ResultSet result = ps.executeQuery();

            if(result.next())
            {
                country.setCode(result.getString("Code"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setName(result.getString("Name"));
                country.setPopulation(result.getInt("Population"));
                country.setSurfaceArea(result.getDouble("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setLifeExpectancy(result.getDouble("LifeExpectancy"));
                country.setGnp(result.getDouble("GNP"));
                country.setGnpOld(result.getDouble("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return country;
    }

    public List<Country> findAll(String region) {
        List<Country> countries = new ArrayList<>();
        String findCountries = "SELECT * FROM country WHERE region=?";

        try(PreparedStatement ps = connection.prepareStatement(findCountries);){
            ps.setString(1, region);
            ResultSet result = ps.executeQuery();
            
            while(result.next())
            {
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setName(result.getString("Name"));
                country.setPopulation(result.getInt("Population"));
                country.setSurfaceArea(result.getDouble("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setLifeExpectancy(result.getDouble("LifeExpectancy"));
                country.setGnp(result.getDouble("GNP"));
                country.setGnpOld(result.getDouble("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
                countries.add(country);
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return countries;
}
}
