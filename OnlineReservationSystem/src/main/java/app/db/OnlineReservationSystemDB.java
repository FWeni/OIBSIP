package app.db;

import model.Person;
import model.User;

import java.sql.*;

public class OnlineReservationSystemDB {
    public void theDatabase(){
        String url = "jdbc:sqlite::memory:";

        Person person = new Person();

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            String userTable = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, " +
                    "name TEXT NOT NULL, " +
                    "lastname TEXT NOT NULL, " +
                    "securityNumber TEXT NOT NULL, " +
                    "dateOfBirth TEXT NOT NULL"+
                    "username TEXT NOT NULL, " +
                    "password TEXT NOT NULL)";
            statement.execute(userTable);

            String bookingTable = "CREATE TABLE IF NOT EXISTS booking (id INTEGER PRIMARY KEY, name TEXT NOT NULL)";
            statement.execute(bookingTable);

            userTable = "INSERT INTO users (name, lastname, username, securityNumber, password) VALUES";
            statement.execute(userTable);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
