package org.example.interfaces;

public interface LinkedList<T> {
    int size();

    boolean isEmpty();

    T get(int position);

    void insertAtBeginning(T data);

    void insertAtEnd(T data);

    void deleteAtBeginning();

    void deleteAtEnd();

    void delete(int pos);

    String toString();

}
