import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SLListTest {

    SLList ListForTesting = new SLList();
    @Test
    void testThrowgetFirs() {
        assertThrows(IndexOutOfBoundsException.class, () -> ListForTesting.getFirst());
        ListForTesting.addFirst(50);
        assertDoesNotThrow(() -> ListForTesting.getFirst());
    }
    @Test
    void testThrowget() {
        assertThrows(IndexOutOfBoundsException.class, () -> ListForTesting.get(0));
        ListForTesting.addFirst(10);
        assertThrows(IndexOutOfBoundsException.class, () -> ListForTesting.get(2));
        ListForTesting.addFirst(30);
        assertThrows(IndexOutOfBoundsException.class, () -> ListForTesting.get(10_000));
        assertDoesNotThrow(() -> ListForTesting.get(1));
    }
}