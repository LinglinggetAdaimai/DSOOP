import java.util.Arrays;

public class Zombies {

    /**
     * Our merge-like algo should compute two things
     *   the combined sorted list
     *   the number of out-of-wack-pairs
     * It should look like mergesort but just with this additional
     *
     */

    // the code is from https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/
    // but since we're trying to find the pair where the bigger on has bigger index than the smallerone
    // So here's the changes I've made
        // reverse the sort to be largest to smallest to check the violation
        // make use only 1 while loop instead of 3 in the website
    private static int mergeAndCount(int[] arr, int l, int m, int r) {
        int i = 0, j = 0, k = l, swaps = 0;
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int len_left = left.length, len_right = right.length;

        while (i+j < len_left + len_right) {
            if (i >= len_left) // run out of a
                arr[k++] = right[j++];
            else if (j >= len_right) // run out of b
                arr[k++] = left[i++];
            else if (left[i] >= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        return swaps;
    }

    private static int mergeSortAndCount(int[] arr, int l, int r) {
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

    public static int countBad( int[] hs) {
        return mergeSortAndCount(hs, 0, hs.length-1);
    }
    public static void main(String[] args) {
        int[] arr1 = {3, 1, 4, 2};
        int[] arr2 = {5, 4, 11, 7};
        int[] arr3 = {1, 7, 22, 13, 25, 4, 10, 34, 16, 28, 19, 31};
        int[] arr4 = {2, 4, 3, 7, 1};
        System.out.println(mergeSortAndCount(arr1,0, arr1.length-1));
        System.out.println(mergeSortAndCount(arr2,0, arr2.length-1));
        System.out.println(mergeSortAndCount(arr3,0, arr3.length-1));
        System.out.println(mergeSortAndCount(arr4,0, arr4.length-1));
    }
}