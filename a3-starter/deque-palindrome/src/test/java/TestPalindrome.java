// IMPORTANT: Uncomment this file after you're done with the Deque interface and wordToDeque

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindromenormal() {
        // all true
        String palin1 = "LinggniL";
        String palin2 = "deified";
        String palin3 = "stats";
        String palin4 = "goawayyawaog";
        String palin5 = "";
        String palin6 = "a";
        String palin7 = "77811877";

        assertTrue(palindrome.isPalindrome(palin1));
        assertTrue(palindrome.isPalindrome(palin2));
        assertTrue(palindrome.isPalindrome(palin3));
        assertTrue(palindrome.isPalindrome(palin4));
        assertTrue(palindrome.isPalindrome(palin5));
        assertTrue(palindrome.isPalindrome(palin6));
        assertTrue(palindrome.isPalindrome(palin7));

        // all false
        String npalin1 = "Owo";
        String npalin2 = "jingjai";
        String npalin3 = "maiAm";
        String npalin4 = "MiAmi";
        String npalin5 = "LOveLYevoL";
        String npalin6 = "BrIAnAiRb";

        assertFalse(palindrome.isPalindrome(npalin1));
        assertFalse(palindrome.isPalindrome(npalin2));
        assertFalse(palindrome.isPalindrome(npalin3));
        assertFalse(palindrome.isPalindrome(npalin4));
        assertFalse(palindrome.isPalindrome(npalin5));
        assertFalse(palindrome.isPalindrome(npalin6));

    }

    private OffByOne Offbyone = new OffByOne();
    private OffByN OffbyZero = new OffByN(0);
    private OffByN OffbyThree = new OffByN(3);
    private OffByN OffbyFive = new OffByN(5);

    @Test
    public void testIsPalindromeOffbyN() {

        String palin1 = "afgheb";
        String palin2 = "xyzxw";
        String palin3 = "jingnij";
        String palin4 = "goawayyawaog";

        // three-off odd
        String palin5 = "DrioG";
        // three-off even
        String palin6 = "KVcfYN";

        //five-off odd
        String palin7 = "arstnwf";
        //five-off even
        String palin8 = "euzj";

        // five-off not palindrome
        String palin9 = "euyj";
        String palin10 = "lovely";

        assertTrue(palindrome.isPalindrome(palin1, Offbyone));
        assertTrue(palindrome.isPalindrome(palin2, Offbyone));
        assertTrue(palindrome.isPalindrome(palin3, OffbyZero));
        assertTrue(palindrome.isPalindrome(palin4, OffbyZero));
        assertTrue(palindrome.isPalindrome(palin5, OffbyThree));
        assertTrue(palindrome.isPalindrome(palin6, OffbyThree));
        assertTrue(palindrome.isPalindrome(palin7, OffbyFive));
        assertTrue(palindrome.isPalindrome(palin8, OffbyFive));

        assertFalse(palindrome.isPalindrome(palin1,OffbyFive));
        assertFalse(palindrome.isPalindrome(palin1,OffbyFive));
        assertFalse(palindrome.isPalindrome(palin1,OffbyFive));

    }

}
