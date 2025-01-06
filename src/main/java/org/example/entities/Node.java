package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node<T> {

    private T data;
    private Node<T> prev;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

}