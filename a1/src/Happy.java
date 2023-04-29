package Happy;
// 23:25
public class Happy {
    

    // Subtask 1: take positive num and sqrt it one by one
    public static long sumOfDigitsSquared(long n) {

        long result = 0;
        
        // get each digit sqrt by mod 10 to get the last digit, 
            // under cond.: num/10 != 0 [if it's == 0 then it means no num left to deal with]
        while (n != 0) {
            
            // result + the power of the last digit
            result += (n%10) * (n%10);

            // shift the num we're dealing with to the right, to deal with the next num to the left
            n /= 10;
        }
        
        // System.out.println(result);
        return result;
    }

    // 23:42
    // Subtask II
    public static boolean isHappy(long n) {
  
        while (true) {
                        
            // base for >< (1) or T-T (4)
            if (n == 4){
                return false;
            } else if (n == 1) {
                return true;
            }
            
            n = sumOfDigitsSquared(n);
        }
    
    }

    // 23:49
    public static long[] firstK(int k) {
        // get k happy number

        long[] result = new long[k];
        long num = 1;
        int index = 0;

        // check if happy or not
            // if happy then put num in the index and increment index == to move to the next element to replace with happy num
            // else just increment the num we're checking
        while (index < k){
            
            if (isHappy(num)) {
                result[index] = num;
                index++;
            }
            num++;
        }
        return result;
    }

}
