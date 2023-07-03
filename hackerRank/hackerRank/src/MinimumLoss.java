import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumLoss {

            static void mergeInto(Long[] a, Long[] b, Long[]out) {
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
            static void mergeSort(Long[] a) {
                int n = a.length;
                if (n <= 1) return;


                Long[] left = Arrays.copyOfRange(a, 0, n/2);
                Long[] right = Arrays.copyOfRange(a, n/2, n);

                mergeSort(left); mergeSort(right);
                mergeInto(left, right, a);
        }

        public static int minimumLoss(List<Long> price) {
            // store it in hashmap, so we can check the index
            // merge sort
            // loop through to find the diff between elements
            // if index i > index i+1 in price then store
            int length = price.size();
            Long[] sorted_arr = new Long[length];
            HashMap<Long, Integer> mapForIndex = new HashMap<>();
            for (int i = 0; i < length; i++){
                mapForIndex.put(price.get(i), i);
                sorted_arr[i] = price.get(i);
            }

            mergeSort(sorted_arr);

            long mindiff = Long.MIN_VALUE;
            for (int i = 0; i < length-1; i++){
                Long diff = sorted_arr[i] - sorted_arr[i+1];
                if (mapForIndex.get(sorted_arr[i]) > mapForIndex.get(sorted_arr[i+1]) && diff > mindiff) {
                    mindiff = diff;
                }
            }
            return (int) mindiff*-1;

        }


}
