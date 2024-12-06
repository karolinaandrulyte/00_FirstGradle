import org.example.entities.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    DoublyLinkedList<String> list;

    @BeforeEach
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    public void sizeIsZeroWhenListIsEmpty() {
        DoublyLinkedList <String> list = new DoublyLinkedList<>();
        int size = list.
            assertThat(size,equalTo(0));
            assertTrue(list.isEmpty());
    }

    @Test
    public void testInsertAtBeginning() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtBeginning("First");
        assertEquals(1, list.size());
        list.insertAtBeginning("Second");
        assertEquals(2, list.size());
        assertEquals("Second", list.head.data);
    }

    @Test
    public void testInsertAtEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtEnd("First");
        list.insertAtEnd("Second");
        assertEquals(2, list.size());
        assertEquals("Second", list.tail.data);
    }

    @Test
    public void testInsertAtPosition() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtEnd("First");
        list.insertAtEnd("Third");
        list.insertAtPosition("Second", 2);
        assertEquals(3, list.size());
        assertEquals("Second", list.head.next.data);
    }

    @Test
    public void testDeleteAtBeginning() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtEnd("First");
        list.insertAtEnd("Second");
        list.deleteAtBeginning();
        assertEquals(1, list.size());
        assertEquals("Second", list.head.data);
    }

    @Test
    public void testDeleteAtEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtEnd("First");
        list.insertAtEnd("Second");
        list.deleteAtEnd();
        assertEquals(1, list.size());
        assertEquals("First", list.head.data);
    }

    @Test
    public void testDeleteAtPosition() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtEnd("First");
        list.insertAtEnd("Second");
        list.insertAtEnd("Third");
        list.delete(2);  // Delete the second element
        assertEquals(2, list.size());
        assertEquals("Third", list.head.next.data);
    }

}
