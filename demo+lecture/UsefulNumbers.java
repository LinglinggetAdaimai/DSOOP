

public class UsefulNumbers {
    // public static void main(String[] args) {
        
    //     int secondsInAMinute = 60;
    //     int secondsInAnHour = 60 * secondsInAMinute;
    //     int secondsInADay = 24 * secondsInAnHour;
    //     long secondsInAYear = 365 * secondsInADay;
    //     long secondsInACentury = 100 * secondsInAYear;

    //     // System.out.printf("%d",secondsInAMinute);
    //     // System.out.printf("%d",secondsInAnHour);
    //     // System.out.printf("%d",secondsInADay);
    //     // System.out.printf("%lld",secondsInAYear);
    //     // System.out.printf("%lld",secondsInACentury);
    //     System.out.printf("One century contains %d seconds.\n", secondsInACentury);

    // }


    public static int maxFor(int[] numbers) {
        int max = numbers[0];

        for (int num: numbers) {
            // if curr is more than max then change the num in max
            if (num > max) {
                max = num;
            }
        }

        return max;
    }
    public static int maxWhile(int[] numbers) {
        int max = numbers[0];
        int index = 1;
        while (index < numbers.length){
            if (numbers[index] > max) {
                max = numbers[index];
            }
            index++;
        }
        return max; 
    }




    public static void main(String[] args) {
        // int[] numbers = {1,2,3}; 

        // for (int num: numbers) {
        // // sysout == System.out.println
        // System.out.println(num);
        // }

        // if you declaer without any number then it won't print out
        // int index = 0;

        // while (index < numbers.length) {


        // }

        // System.out.println(maxFor(numbers));
        // System.out.println(maxWhile(numbers));
        // System.out.println(Arrays.tostring(numbers));


    }

    


    
}