package daos;

import java.util.List;

public interface Dao<T, PK> { //defining the generic type, T - type of entity we are passing, PK - data type for the primary key
    List<T> findAll(); // This method retrieves all the rows from the T table and returns them as a List of T objects
    T findById(PK pk); // This method retrieves a single row from the T table with the ID passed as a parameter and returns it as a T object
    void insert(T item); // This method inserts a new row into the T table with the data in the T object passed as a parameter
    Boolean update(T item); // This method updates the field of a row in the T table with the same ID as the T object passed as a parameter
    Boolean delete(PK pk); // This method deletes a single row from the T table with the ID passed as a parameter and returns a boolean indicating whether the operation was successful or not
    T findByName(String name); // This method retrieves a single row from the T table with the name passed as a parameter and returns it as a T object
    List<T> findAll(String code);  // This method retrieves all the rows from the T table that have the same code as the one passed as a parameter and returns them as a List of T objects
}
