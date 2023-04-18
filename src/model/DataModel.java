package model;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import java.util.Random;

import daos.CityDao;
import entities.City;
import entities.Database;

public class DataModel {
    /*public static String[][] getData()
    {
        
    }*/


    //Get City Data
    public static String[][] getCityData()
    {
        String[][] cityData = null;
        try(Connection connection = Database.getDatabaseConnection())
        {
            CityDao cityDao = new CityDao(connection);
            List<City> cities = cityDao.findAll();
            cityData = new String[cities.size()][5];
            int row = 0;
            for(City city: cities) {
                cityData[row][0] = city.getID().toString();
                cityData[row][1] = city.getName();
                cityData[row][2] = city.getCountryCode();
                cityData[row][3] = city.getDistrict();
                cityData[row][4] = city.getPopulation().toString();
                row++;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return cityData;
    }

    //Get headers for city table
    public static String[] getHeaders()
    {
        String[] headers = new String[5];
        headers[0] = "ID";
        headers[1] = "Name";
        headers[2] = "Country Code";
        headers[3] = "District";
        headers[4] = "Population";

        return headers;
    }
}

