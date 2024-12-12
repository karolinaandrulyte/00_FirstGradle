package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.example.entities.DoublyLinkedList;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        try {
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("text.txt");
            if (inputStream == null) {
                throw new FileNotFoundException("Resource 'text.txt' not found.");
            }

            Scanner myReader = new Scanner(inputStream);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.insertAtEnd(data);
                System.out.println(data);
            }
            myReader.close();

        } catch (IOException e) {
            System.out.println("IOException occurred.");
            e.printStackTrace();
        }

        list.get(2);
        list.delete(1);
        list.traverseForward();

        System.out.println();
        System.out.println(list);
    }

}