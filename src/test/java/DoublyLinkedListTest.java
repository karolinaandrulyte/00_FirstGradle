import org.example.entities.DoublyLinkedList;
import org.example.entities.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Tests should cover edge cases and typical usage scenarios to validate list behavior.
public class DoublyLinkedListTest {

    private DoublyLinkedList<String> list;

    @BeforeEach
    public void setUp() {
        list = new DoublyLinkedList<>();
    }
//    Verifies the initial state of the list when it is created
    @Test
    public void testListInitialization() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testInsertAtBeginning() {
        list.insertAtBeginning("A");
        list.insertAtBeginning("B");
        assertEquals(2, list.size());
        assertEquals("B", list.getHead().getData());
        assertEquals("A", list.getTail().getData());
    }

    @Test
    public void testInsertAtEnd() {
        list.insertAtEnd("A");
        list.insertAtEnd("B");
        assertEquals(2, list.size());
        assertEquals("A", list.getHead().getData());
        assertEquals("B", list.getTail().getData());
    }

    @Test
    public void testDeleteAtBeginning() {
        list.insertAtEnd("A");
        list.insertAtEnd("B");
        list.deleteAtBeginning();
        assertEquals(1, list.size());
        assertEquals("B", list.getHead().getData());
    }

    @Test
    public void testDeleteAtEnd() {
        list.insertAtEnd("A");
        list.insertAtEnd("B");
        list.deleteAtEnd();
        assertEquals(1, list.size());
        assertEquals("A", list.getTail().getData());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.insertAtEnd("A");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testGet() {
        list.insertAtEnd("A");
        list.insertAtEnd("B");
        assertEquals("A", list.get(1));
        assertEquals("B", list.get(2));
    }

    public void testTraversal() {
        list.insertAtEnd("A");
        list.insertAtEnd("B");
        list.insertAtEnd("C");

        StringBuilder result = new StringBuilder();
        Node<String> current = list.getHead();
        while (current != null) {
            result.append(current.getData()).append(" ");
            current = current.getNext();
        }

        assertEquals("A B C ", result.toString().trim());
    }

    @Test
    public void testToString() {
        list.insertAtEnd("A");
        list.insertAtEnd("B");
        assertEquals("DoublyLinkedList{A -> B}", list.toString());
    }

    @Test
    public void testEquality() {
        DoublyLinkedList<String> list1 = new DoublyLinkedList<>();
        list1.insertAtEnd("A");
        list1.insertAtEnd("B");

        DoublyLinkedList<String> list2 = new DoublyLinkedList<>();
        list2.insertAtEnd("A");
        list2.insertAtEnd("B");

        assertEquals(list1, list2);
    }

}
