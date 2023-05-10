import java.util.Arrays;

class Box {
    int min;
    int max;
}

public class MinMax {
    /* Logic: helper that is a recursive function that takes in an array and break it down,
    until it has only 2 element and give back a box [min, max] and then compare with the other half and return min, max again
        MaxnMin (int [] array) and returns [min, max] 

        There are 4 cases in this function
            case a: array length == 0
                return [0, 0]
            case b: array length == 1 -- this case is for when the number has no pair 
                return [array[0], array[0]]
            case c: array length == 2 -- find the max min between two 
                if [0] > [1] -> return [array[1], array[0]]
            case d: array length > 2 

                divide it in half, the amount of the first half and the second don't have to be the same
                call the MaxnMin function to divide the array untill it left with only 2 elements in the list
            
                    there will be 2 two-elements arrays and 2 variables for index
                        - len = array.length 
                        - half = len/2
                        - right = MaxnMin(array[half+1:len])
                        - left = MaxnMin(array[:half])

                after that compare the max and min from left and right 
                return [min, max]       
                
    */

    public static Box MaxnMin (int[] array) {

        Box result = new Box();
        int len = array.length;

        if (len == 0) {
            result.min = 0;
            result.max = 0;
            // return result;
        }
        else if (len == 1) {
            result.min = array[0];
            result.max = array[0];
            // return result;
        }
        else if (len == 2) {
            if (array[0] < array[1]) {
                result.min = array[0];
                result.max = array[1];
                // return result;
            }
            else {
                result.min = array[1];
                result.max = array[0];
            }
        }
        else if (len > 2) {
            
            int half = len/2;
            int[] first = Arrays.copyOfRange(array, 0, half);
            int[] second = Arrays.copyOfRange(array, half, len);
            Box left = MaxnMin(first);
            Box right = MaxnMin(second);


            // check the max numbers from left & right box
            if (left.max > right.max) {
                result.max = left.max;
            } 
            else {
                result.max = right.max;
            }
            
            // check the min numbers from left & right box
            if (left.min < right.min) {
                result.min = left.min;
            }
            else {
                result.min = right.min;
            }
            
            
        }
        return result;
    }
        
    public static double minMaxAverage(int[] numbers) {

        Box minmax = MaxnMin(numbers);
        return (minmax.min + minmax.max)/2.0;  

        }

}
