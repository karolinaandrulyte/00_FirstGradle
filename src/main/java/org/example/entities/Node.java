package org.example.entities;

public class Node<T> {

    private T data;
    private Node<T> prev;
    private Node<T> next;
//By restricting direct access, prevent unintentional or incorrect modifications of the Node's state, ensuring the consistency of the linked list.

    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + ", prev=" + prev + ", next=" + next + "]";
    }

}