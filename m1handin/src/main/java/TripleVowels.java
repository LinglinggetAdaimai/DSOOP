public class TripleVowels {
    public static boolean IsVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ) ;
    }

    public static boolean hasTripleVowels(String st) {

        int count = 0;

        for (int index = 0; index < st.length(); index++) {
            char ch = st.charAt(index);

            if(IsVowel(ch)) {
                count++;
            }
            else { count = 0;}

            // check if we've reached 3 vowels
            if (count == 3) {
                return true;
            }
        }
        return count == 3;
    }

    public static void main(String[] args) {
        String[] tests     = {"fooo", "OoO", "baZaa", "fooA", "moraiene"};
        boolean[] expected = {true  , true , false  , true  ,  true};
        int numPassed = 0;
        for (int i=0;i<tests.length;i++) {
            boolean result = hasTripleVowels(tests[i]);
            if (result == expected[i]) 
                numPassed++;
        }
        System.out.printf("== Passed %d out of %d cases\n", numPassed, tests.length);

    }
}
