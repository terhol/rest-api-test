package se.terhol.restapitest.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database connector.
 *
 * @author Tereza Holm
 */
public class DatabaseConnector {
    private static final Logger LOGGER = Logger.getLogger(DatabaseConnector.class.getName());

    public static Properties getProperties() {
        Properties properties = new Properties();

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            properties.load(classLoader.getResourceAsStream(DatabaseConstants.PATH));
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return properties;
    }

    private static Connection getConnection() throws SQLException {
        Properties props = getProperties();

        String url = props.getProperty(DatabaseConstants.URL);
        String user = props.getProperty(DatabaseConstants.USER);
        String password = props.getProperty(DatabaseConstants.PASSWORD);

        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Retrieves data from database by the given SQL query.
     *
     * @param query SQL query which we would like to execute
     * @return result set which represents retrieved data
     * @throws SQLException when an error occurs when connecting to database
     */
    public ResultSet retrieveData(String query) throws SQLException {
        return getConnection().prepareStatement(query).executeQuery();
    }
}