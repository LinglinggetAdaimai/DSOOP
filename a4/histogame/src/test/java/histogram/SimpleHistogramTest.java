package histogram;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;

public class SimpleHistogramTest {

    @Test
    public void testHistogram() {
        Character[] target = {'a','b','c','a'};
        Histogram<Character> h = new SimpleHistogram<>(target);
        Iterator<Character> iter = h.iterator();
        int elemCount = 0;
        while(iter.hasNext()) {
            iter.next();
            elemCount++;
        }

        assertEquals(3, elemCount);
        assertEquals(2, h.getCount('a'));
        assertEquals(1, h.getCount('b'));
        assertEquals(1, h.getCount('c'));
        assertEquals(4, h.getTotalCount());
    }

    @Test
    public void testHistogrambyme() {
        Integer[] nums = {1, 4, 5, 4, 3, 1, 2, 3, 3, 2};
        Histogram<Integer> hist = new SimpleHistogram<>(nums);

        assertEquals(hist.getCount(3),3);
        assertEquals(hist.getCount(1),2);
        assertEquals(hist.getCount(2),2);
        assertEquals(hist.getCount(4),2);
        assertEquals(hist.getCount(16),0);

        hist.setCount(9,18);
        assertEquals(hist.getCount(9),18);

    }
}

