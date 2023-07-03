import java.util.*;

public class Results {

    static void mergeInto(int[] a, int[] b, int[]out) {
        int i = 0, j = 0;
        for (int o=0; o < out.length; o++) {
            if (i >= a.length) // run out of a
                out[o] = b[j++];
            else if (j >= b.length)
                out[o] = a[i++];
            else if (a[i] < b[j]) // move head of a
                out[o] = a[i++];
            else
                out[o] = b[j++];
        }
    }
    static void mergeSort(int[] a) {
        int n = a.length;
        if (n <= 1) return;


        int[] left = Arrays.copyOfRange(a, 0, n/2);
        int[] right = Arrays.copyOfRange(a, n/2, n);

        mergeSort(left); mergeSort(right);
        mergeInto(left, right, a);
    }

    public static long minDivCon(List<Long> price, int start, int end ){
        int length = end-start;
        if (length == 1) return price.get(start);
        if (length == 2) {
            if (price.get(start) > price.get(end-1)) {return price.get(end-1);}
            else {return price.get(start);}
        }

        else {
            return minDivCon(price, start,length/2); // T(n/2)
        }
    }



}
