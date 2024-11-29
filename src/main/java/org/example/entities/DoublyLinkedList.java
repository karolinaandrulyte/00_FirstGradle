package org.example.entities;

import org.example.interfaces.LinkedList;

public class DoublyLinkedList <T> implements LinkedList {

    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int size() {
        int size = 0;
        Node<T> current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size; }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public T get(int position) {
        if (position <= 0 || position > size()) {
            System.out.println("Position out of range.");
            return null;
        }

        Node<T> current = head;
        int count = 1;

        while (current != null && count < position) {
            current = current.getNext();
            count++;
        }

        return current != null ? current.getData() : null;
    }


    public void traverseForward() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
    }

    public void traverseBackward() {
        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getPrev();
        }
    }


    public void insertAtBeginning(T data) {
        Node<T> temp = new Node<>(data);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
        }
    }


    public void insertAtEnd(T data) {
        Node<T> temp = new Node<>(data);
        if (tail == null) {
            head = temp;
            tail = temp;
        }
        else {
            tail.setNext(temp);
            temp.setPrev(tail);
            tail = temp;
        }
    }

    public void insertAtPosition(T data, int position) {
        Node<T> temp = new Node<>(data);
        if (position == 1) {
            insertAtBeginning(data);
        } else {
            Node<T> current = head;
            int currPosition = 1;
            while (current != null && currPosition < position) {
                current = current.getNext();
                currPosition++;
            }
            if (current == null) {
                insertAtEnd(data);
            } else {
                temp.setNext(current);
                temp.setPrev(current.getPrev());
                current.getPrev().setNext(temp);
                current.setPrev(temp);
            }
        }
    }


    public void deleteAtBeginning()  {
        if (head == null) {
            return;
        }


        if (head == tail) {
            head = null;
            tail = null;
            return;
        }


        Node<T> temp = head;
        head = head.getNext();
        head.setPrev(null);
        temp.setNext(null);
    }

    public void deleteAtEnd() {
        if (tail == null) {
            return;
        }


        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node<T> temp = tail;
        tail = tail.getPrev();
        tail.setNext(null);
        temp.setPrev(null);
    }

    public void delete(int pos) {
        if (head == null) {
            return;
        }


        if (pos == 1) {
            deleteAtBeginning();
            return;
        }

        Node<T> current = head;
        int count = 1;

//	       TODO rewrite if position is 0 or less (in all methods?)
        if (pos > size()) {
            return;
        }

        while (current != null && count != pos) {
            current = current.getNext();
            count++;
        }


        if (current == null) {
            System.out.println("Position wrong");
            return;
        }


        if (current == tail) {
            deleteAtEnd();
            return;
        }

        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        current.setPrev(null);
        current.setNext(null);
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DoublyLinkedList{");

        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(" -> ");
            }
            current = current.getNext();
        }

        sb.append("}");
        return sb.toString();
    }




}