package se.terhol.restapitest.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import se.terhol.restapitest.dto.Person;

/**
 * Creates person DTO based on data retrieved from database.
 *
 * @author Tereza Holm
 */
public class PersonCreator {
    private static final Logger LOGGER = Logger.getLogger(DatabaseConnector.class.getName());

    private static final String SELECT_RANDOM_PERSON = "select firstname, lastname from people limit 1;";

    private DatabaseConnector dbConnector = new DatabaseConnector();

    /**
     * Constructs one random person based on data from database.
     *
     * @return one random person
     */
    public Person getRandomPerson() {
        try {
            ResultSet rs = dbConnector.retrieveData(SELECT_RANDOM_PERSON);
            rs.next();

            String firstName = rs.getString(1);
            String lastName = rs.getString(2);

            return new Person(firstName, lastName);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);

            return null;
        }
    }
}
