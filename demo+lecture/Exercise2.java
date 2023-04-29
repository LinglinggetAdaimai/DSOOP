import java.math.BigInteger;

public class Exercise2 {


    public static int numTrailingZeros(int n){


        // find the n!
        BigInteger nFac = BigInteger.valueOf(1L); // you cannot use long, it's overflow
        
        // loop untill the i is the given number
        for (int i = 2; i <= n; i++) {
            nFac = nFac.multiply(BigInteger.valueOf(i));
        }
     
        // System.out.println(nFac);

        // % and get 0 count 1
        
        // tracking that increase everytime we found 0
        int times = 0;

        // compare the factorial with 0
        // while divide by 10 is the n
        while (!(nFac.equals(BigInteger.ZERO))) {

            // get the result and remainder in terms of [result, remainder]
            BigInteger[] result  = nFac.divideAndRemainder(BigInteger.valueOf(10));

            // check if the last digit is 0 by %10
            if ((result[1]).equals(BigInteger.ZERO)){
                times++;
            } else {
                // if it's not zero then stop the loop and return the times
                break;
            }
            
            // set the next number that we're gonna dealing with to the number that we already delete last digit
            nFac = result[0];
            

        }

        return times;

    }

    public static void windowPosSum(int[] a, int n) {
        // given an array[x] and n 
        // sum each element starting from [0] until [i+n]
        // when loop to add up please make a condition for it

        int arraylength = a.length;
        
        for (int index = 0; index < arraylength; index++) {
            if (a[index] > 0) {
                
                // increment until the index of the number that we're adding is equal to the last ele
                for (int indexForsum = index+1 ; indexForsum < arraylength && indexForsum <= (index+n); indexForsum++) {
                    a[index] += a[indexForsum];
                }

            }
        }
        
    }
    


}
