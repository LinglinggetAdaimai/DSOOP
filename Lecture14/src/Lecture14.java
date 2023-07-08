public class Lecture14 {


    public static int linearSearch(String[] array, String targetKey){
        for (int index = 0; index < array.length; index++){
            if (array[index].compareTo(targetKey) == 0) return index;
        }
        return -1;
    }

    public static int binarySearch(String[] array, String targetKey){
        int len  = array.length-1 ;
        int start = 0 , end = len;
        int midIndex;
        // Loop to implement Binary Search
        while (start <= end ) {
            midIndex = (end - start)/2;
            int compareVal = array[midIndex].compareTo(targetKey);
            if (compareVal == 0) return midIndex;
            if (compareVal > 0) {start = 0; end = midIndex;}
            if (compareVal < 0) {start = midIndex +1;}
        }
        return -1;
    }

/**
 * Running Time Analysis
 */

/**
 * int primSum(int[] xs) {
 *      if (xs.length == 1) return xs[0]; O(1)
 *      if (xs.length == 2) return xs[0] + xs[1]; O(1)
 *      else {
 *          int[] ys = Arrays.copyOfRange(xs, 1, xs.length); O(n)
 *          return xs[0]+xs[1]+primSum(ys); O(1) + O(1) + T(n-1)
 *      }
 * }
 *
 * primSum: O(1) + T(n-1) -> O(n) ANS
 */

/**
 * int whazIt(int[] ys) {
 *     if (ys.length == 0) return 0; O(1)
 *     if (ys.length == 1) return ys[0]; O(1)
 *     int n = ys.length; O(1)
 *     int m = n/2; O(1)
 *     for (int i=0;i<n;i++) { O(n^2)
 *         int theSum = 0;
 *         for (int j=0;j<=i;j++) { theSum += ys[j]; }
 *         ys[i] = theSum;
 *     }
 *     int a = whazIt(Arrays.copyOfRange(ys, 0, m)); T(n/2)
 *     int b = whazIt(Arrays.copyOfRange(ys, m, ys.length)); T(n/2)
 *     return a + b; O(1)
 * }
 *
 * whazIt: O(1) + O(n^2) + 2T(n/2) + O(1) -> 2T(n/2) + O(n^2) -> O(n^2) ANS
 */
}
