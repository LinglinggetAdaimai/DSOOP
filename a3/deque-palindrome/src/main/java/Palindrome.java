class Palindrome {
    // should return a Deque where the characters appear in the same order
    // as the given string. meow -> get the one that is meow.
    // after you're done, uncomment the palindrome test file
    public Deque<Character> wordToDeque(String word) {
         Deque<Character> deque = new ArrayDeque<>();
        if (word.length() == 0) {
            return deque;
        }
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    // return true if the given word is palindrome.
    // Palindrome: "a" "racecar", any given word that is 0, 1 char long is always a palindrome
    // this function is case-sensitive: "A" and "a" aren't the same
    // Requirements:
            // you must use a Deque in implementing this function
                    // use wordToDeque to convert the given string to Deque
                    // then read and compare
            // you shouldn't be using get(), it will make things complicated
    // After you're done, add more tests in TestPalindrome, to make sure the func works
    public boolean isPalindrome(String word) {
        int strlen = word.length();
        if (strlen == 0 || strlen == 1) { // if a char or nothing, always palindrome
            return true;
        }

        Deque<Character> wordInDeque = wordToDeque(word);
        for (int i = 0; i < strlen/2; i++){ // loop through to find the diff
            if (wordInDeque.removeLast() != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // user will pass in word and then the condition for comparing (cc)
    // if the word is an odd-length palindromes, check only the first & last char if it's off-by-1
        // "flake" is an off-by-1 palindrome
    // add more test cases in TestPalindrome
    public boolean isPalindrome(String word, CharacterComparator cc){
        int strlen = word.length();
        if (strlen == 0 || strlen == 1) { // if a char or nothing, always palindrome
            return true;
        }

        Deque<Character> wordInDeque = wordToDeque(word);

        for (int i = 0; i < strlen/2; i++){

            if (!(cc.equalChars(wordInDeque.removeLast(), word.charAt(i)))) {
                return false;
            }
        }
        return true;

    }
}