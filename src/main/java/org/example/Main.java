package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import org.example.entities.DoublyLinkedList;

public class Main {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\karandr\\IdeaProjects\\00_FirstGradle\\src\\main\\java\\text.txt";

        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
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

//      move to get()
        Optional<String> checkNull = Optional.ofNullable(list.get(2));

        if (checkNull.isPresent()) {
            String e = list.get(2).toUpperCase();
            System.out.println("The second element is " + e);
        }

        else
            System.out.println("Element is null");

        System.out.println("There are " + list.size() + " elements in the list");

        list.delete(1);
        list.traverseForward();

        System.out.println();
        System.out.println(list);

    }

}