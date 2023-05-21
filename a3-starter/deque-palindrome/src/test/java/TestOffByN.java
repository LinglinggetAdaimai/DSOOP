import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TestOffByN {
    static CharacterComparator offByoNe = new OffByN(1);
    static CharacterComparator offByZero = new OffByN(0);
    static CharacterComparator offBythree = new OffByN(3);

    @Test
    public void testOffbyone() {
        assertTrue(offByoNe.equalChars('b','a'));
        assertTrue(offByoNe.equalChars('c','d'));
        assertTrue(offByoNe.equalChars('j','k'));
        assertTrue(offByoNe.equalChars('R','Q'));
        assertTrue(offByoNe.equalChars('U','V'));
        assertTrue(offByoNe.equalChars('w','x'));

        assertFalse(offByoNe.equalChars('a','x'));
        assertFalse(offByoNe.equalChars('E','U'));
        assertFalse(offByoNe.equalChars('v','B'));
        assertFalse(offByoNe.equalChars('K','j'));
        assertFalse(offByoNe.equalChars('N','m'));
    }
    @Test
    public void testOffbyZero() {
        assertTrue(offByZero.equalChars('a','a'));
        assertTrue(offByZero.equalChars('D','D'));
        assertTrue(offByZero.equalChars('k','k'));
        assertTrue(offByZero.equalChars('q','q'));
        assertTrue(offByZero.equalChars('v','v'));
        assertTrue(offByZero.equalChars('x','x'));

        assertFalse(offByZero.equalChars('L', 'O'));
        assertFalse(offByZero.equalChars('d', 'D'));
        assertFalse(offByZero.equalChars('r', 't'));
        assertFalse(offByZero.equalChars('q', 'p'));
        assertFalse(offByZero.equalChars('r', 'a'));
    }


    @Test
    public void testOffbyThree() {

        assertTrue(offBythree.equalChars('a', 'd'));
        assertTrue(offBythree.equalChars('k', 'h'));
        assertTrue(offBythree.equalChars('S', 'P'));
        assertTrue(offBythree.equalChars('G', 'D'));
        assertTrue(offBythree.equalChars('S', 'V'));
        assertTrue(offBythree.equalChars('l', 'o'));


        assertFalse(offBythree.equalChars('M', 'o'));
        assertFalse(offBythree.equalChars('l', 'O'));
        assertFalse(offBythree.equalChars('g', 'D'));
        assertFalse(offBythree.equalChars('x', 'y'));
        assertFalse(offBythree.equalChars('a', 'b'));

    }

}
