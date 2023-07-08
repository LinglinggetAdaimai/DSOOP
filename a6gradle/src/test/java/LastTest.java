import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LastTest {

    @Test
    void TestbinarySearchLast() {
        int[] arr1 = {1,2,2,3,5,6,6,6,6,6};

        assertNull(Last.binarySearchLast(arr1, 0));
        assertNull(Last.binarySearchLast(arr1, 10));
        assertEquals(4, Last.binarySearchLast(arr1, 5));
        assertEquals(3, Last.binarySearchLast(arr1, 3));
        assertEquals(9, Last.binarySearchLast(arr1, 6));
        assertEquals(0, Last.binarySearchLast(arr1, 1));

        int[] arr2 = {20,20,20,20,23,25,26,29,31};

        assertEquals(3, Last.binarySearchLast(arr2, 20));
        assertEquals(8, Last.binarySearchLast(arr2, 31));
        assertNull(Last.binarySearchLast(arr2, 100));

    }
}