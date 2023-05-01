public class Hidden {
    public static boolean isHidden(String s, String t) {
        // given s find t in s
        // it's case-sensitive

        int stringlen = s.length();
        int keylen = t.length();
        
        // n_match, gets implemented everytime the char matches
        int n_match = 0;
        
        // the start of our given string(s), so we dont iterate over and over
        int j = 0;
        
        /*              
                        ***Lingling please read this****
        in the code we use while loop == we can find the key string in order(t)
        ex.
        find "eat" in "buargert" will return true if we use for loop 
        because we go through the whole string again, but the point is to find key in order */

        
        // loop through t 
        for (int i = 0; i < keylen; i++) {
            // loop through s
            while (j < stringlen) {
                // if find then add 1 and break to move to the next key's character
                if (s.charAt(j) == t.charAt(i)) {
                    n_match++;
                    break;
                }
                j++;
            }
        }
        // check if the track == lens or not

        return (n_match == keylen);
    }

    public static void main(String[] args) {
       System.out.println(isHidden("ling", "inl"));
       
    }
}
