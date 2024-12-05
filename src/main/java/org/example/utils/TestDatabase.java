package org.example.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDatabase {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement()) {

            System.out.println("Connected to the database!");

            //verify the connection
            ResultSet resultSet = statement.executeQuery("SELECT DATABASE()");
            if (resultSet.next()) {
                System.out.println("Connected to database: " + resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
