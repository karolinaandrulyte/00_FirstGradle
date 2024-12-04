package org.example.entities;

import org.example.interfaces.LinkedList;

import java.util.Objects;
import java.util.Optional;

public class DoublyLinkedList<T> implements LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public int size() {
        int size = 0;
        Node<T> current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    @Override
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

        T data = current != null ? current.getData() : null;

        Optional<T> optionalData = Optional.ofNullable(data);

        optionalData.ifPresentOrElse(
                dataValue -> System.out.println("Element at position " + position + ": " + dataValue),
                () -> System.out.println("Element at position " + position + " is null.")
        );

        System.out.println("There are " + size() + " elements in the list.");
        return data;
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DoublyLinkedList<?> that = (DoublyLinkedList<?>) o;

        if (!Objects.equals(this.head, that.head) || !Objects.equals(this.tail, that.tail)) {
            return false;
        }

        Node<?> currentThis = this.head;
        Node<?> currentThat = that.head;

        while (currentThis != null && currentThat != null) {
            if (!Objects.equals(currentThis.getData(), currentThat.getData())) {
                return false;
            }
            currentThis = currentThis.getNext();
            currentThat = currentThat.getNext();
        }

        return currentThis == null && currentThat == null;
    }

    @Override
    public int hashCode() {
        int result = 1;
        Node<T> current = head;

        while (current != null) {
            result = 31 * result + (current.getData() == null ? 0 : current.getData().hashCode());
            current = current.getNext();
        }

        return result;
    }
}