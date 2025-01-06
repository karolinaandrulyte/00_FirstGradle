package org.example;

import org.example.entities.DoublyLinkedList;
import org.example.services.DatabaseService;
import org.example.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

    @Component
    public class DatabaseAndFileProcessor implements CommandLineRunner {

        @Autowired
        private DatabaseService databaseService;

        @Autowired
        private FileService fileService;

        @Override
        public void run(String... args) {
            if (!databaseService.verifyDatabaseConnection()) {
                System.out.println("Database connection failed");
                return;
            }

            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            fileService.loadFileIntoList("text.txt", list);

            list.get(2);
            list.delete(1);
            list.traverseForward();
            System.out.println();
            System.out.println(list);
        }
}
