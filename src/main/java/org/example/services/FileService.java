package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.interfaces.LinkedList;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class FileService {
    public void loadFileIntoList(String fileName, LinkedList<String> linkedList) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new FileNotFoundException("Resource '" + fileName + "' not found.");
            }

            Scanner myReader = new Scanner(inputStream);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                linkedList.insertAtEnd(data);
                System.out.println(data);
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("IOException occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
