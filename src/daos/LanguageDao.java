package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Language;
import entities.Language.PK;

public class LanguageDao implements Dao<Language, Language.PK> { // we have defined PK data type in Language class
    Connection connection;

    public LanguageDao(Connection connection)
    {
        this.connection = connection;
    }

    public List<Language> findAll() {
        List<Language> languageList = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM CountryLanguage");
            while(result.next()) {
                Language language = new Language(
                    result.getString("CountryCode"),
                    result.getString("Language"),
                    result.getBoolean("IsOfficial"),
                    result.getFloat("Percentage"));
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return languageList;
    }

    //T findById(PK pk);
    public Language findById(PK pk)
    {
        return null;
    }

    public void insert(Language language)
    {
        
    }

    public Boolean update(Language item)
    {
        return true;
    }

    public Boolean delete(PK pk)
    {
        return null;
    }

    public Language findByName(String name) {
        return null;
    }

    @Override
    public List<Language> findAll(String code) {
        return null;
    }

}
