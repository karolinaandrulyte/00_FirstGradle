package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.example.entities.DoublyLinkedList;
import org.example.entities.Node;

public class Main {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\karandr\\IdeaProjects\\00_FirstGradle\\src\\main\\java\\text.txt";

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        Node<String> node;


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
            e.printStackTrace(); }

        System.out.println(list.size());

        list.delete(1);
        list.traverseForward();

        String e = list.get(2);
        System.out.println();
        System.out.println(e);

        System.out.println();
        System.out.println(list);

    }

}