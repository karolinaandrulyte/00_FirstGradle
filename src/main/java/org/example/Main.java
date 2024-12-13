package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.example.entities.DoublyLinkedList;
import org.example.utils.DatabaseConfig;

public class Main {

    public static void main(String[] args) {
        if (!verifyDatabaseConnection()) {
            System.out.println("Database connection failed");
            return;
        }

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        loadFileIntoList("text.txt", list);

        list.get(2);
        list.delete(1);
        list.traverseForward();
        System.out.println();
        System.out.println(list);
    }

    public static boolean verifyDatabaseConnection() {
        try (Connection connection = DatabaseConfig.getConnection();
             Statement statement = connection.createStatement()) {

            //verify the connection
            ResultSet resultSet = statement.executeQuery("SELECT DATABASE()");
            if (resultSet.next()) {
                System.out.println("Connected to database: " + resultSet.getString(1));
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error verifying database connection:");
            e.printStackTrace();
        }
        return false;
    }

    private static void loadFileIntoList(String fileName, DoublyLinkedList<String> list) {
        try {
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new FileNotFoundException("Resource '" + fileName + "' not found.");
            }

            Scanner myReader = new Scanner(inputStream);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.insertAtEnd(data);
                System.out.println(data);
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("IOException occurred while reading the file.");
            e.printStackTrace();
        }
    }

}