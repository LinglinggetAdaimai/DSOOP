import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lecture8Test {

    @Test
    void simpleTestForSumInts() {
        assertEquals(5 , Lecture8.sumInts(2, 3));
        assertEquals(24 , Lecture8.sumInts(5, 19));
    }

    @Test
    void harderTestForSumInts() {
        assertEquals(100_003 , Lecture8.sumInts(100_000, 3));
        assertEquals(240 , Lecture8.sumInts(50, 190));
    }

    @Test
    void testIfFelineIsAlive() {
        Feline fe = new Feline(5, "helloWorld");
        // fe != null
        // ensure fe.w == 5?
        assertEquals(5, fe.w);
        // ensure fe.name is "helloWorld'?
        assertEquals("helloWorld", fe.name);
    }
}