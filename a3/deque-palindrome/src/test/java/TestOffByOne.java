// IMPORTANT: Uncomment this file after you have implemented OffByOne

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOneOffEquals() {
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('b','a'));
        assertTrue(offByOne.equalChars('t','s'));
        assertTrue(offByOne.equalChars('r','q'));
        assertTrue(offByOne.equalChars('K','J'));
        assertTrue(offByOne.equalChars('Z','Y'));

        assertFalse(offByOne.equalChars('a', 'q'));
        assertFalse(offByOne.equalChars('i', 'o'));
        assertFalse(offByOne.equalChars('u', 'U'));
        assertFalse(offByOne.equalChars('q', 'm'));
        assertFalse(offByOne.equalChars('c', 'e'));
        assertFalse(offByOne.equalChars('a', 'n'));
        assertFalse(offByOne.equalChars('i', 's'));
    }



}
