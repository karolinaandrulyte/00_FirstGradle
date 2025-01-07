package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entities.DoublyLinkedList;
import org.example.interfaces.LinkedList;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkedListService {

    private final FileService fileService;

    private LinkedList<String> linkedList = new DoublyLinkedList<>();

    public void initializeAndManipulateList(String fileName) {
        fileService.loadFileIntoList(fileName, linkedList);

        System.out.println(linkedList);
        linkedList.get(2);
        linkedList.delete(1);
        System.out.println(linkedList);
    }

    public void addNode(String value) {
        linkedList.insertAtEnd(value);
    }

    public String display() {
        return linkedList.toString();
    }

    public int getSize() {
        return linkedList.size();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public String getNode(int position) {
        return linkedList.get(position);
    }

    public void insertAtBeginning(String value) {
        linkedList.insertAtBeginning(value);
    }

    public void deleteNode(int position) {
        linkedList.delete(position);
    }

}