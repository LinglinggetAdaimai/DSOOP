import java.math.BigInteger;

public class Fib {

    public static int firstNDigit(int n) {
        // given n,  we have to get the index from the Fib list
        // that is the first number that has that n digits

        // check if n ==1
            // yes then just return 1
        // set the first 2 number 1,1
        // set index to 2 -- current is at index 

        // continue adding untill digits == n

        BigInteger previous_prev = BigInteger.ONE;  // first
        BigInteger previous = BigInteger.ONE; // second

        int index = 3;

        // since we alr set the first 2 num and its digit is 1 
            // so if the given is 1 then just return 1
        if (n == 1) {
            return 1;
        }

        else {

            // loop to make the number untill found the number that has amount digit == n
            while (true) {
                
                // sum the 2 num before 
                BigInteger current = previous.add(previous_prev);

                // convert int to str to check the length
                String intTostr = current.toString();

                // current number's digits
                int digits = (intTostr.length());
                // if the lenght is the same as what is given then return
                if (digits == n) {
                    return index;
                }

                index++;
                // move up the var
                previous_prev = previous;
                previous = current;

            }
        }
    }
}