import java.util.*;

public class Lecture15 {

/**
 * The Comparator<T> interface in Java defines how we can compare objects of type T.
 * The interface expects the existence of a method  int compare(T o1, T o2)
 * if o1 < o2, then compare returns a negative value;
 * if o1 == o2, then compare returns 0 (this should be consistent with .equals);
 * if o1 > o2, then compare returns a positive value.
 *
 * (You may wish to write helper methods or helper classes.)
 */

    /**
     * Should run in O(n^2) in worst case
     */
    static <T> void insertionSort(T[] array, Comparator<T> cc){
            int n = array.length;
            for (int index=1; index < n; index++) {
                T elt = array[index];
                int j = index;
                while (j > 0 && cc.compare(elt,array[j-1]) < 0 ) {
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = elt;
            }
    }


    /**
     * (DONE) Should run in O(nlogn)
     * Implement the version that picks pivots at random.
     * This makes it a randomized algorithm and we expect it to run in time.
     * Unless you're masochistic, it will make sense for your code to internally create an ArrayList from the given array,
     * sort the ArrayList, and copy the results back into the initial array.
     */
    static <T> void quickSort(T[] array, Comparator<T> cc) {
        List<T> a = new ArrayList<>();
        for (T ele: array){
            a.add(ele);
        }
        quickSortHelper(a, cc);
        int i = 0;
        for (T ele: a){
            array[i++] = ele;
        }
    }

    static <T> void quickSortHelper(List<T> a, Comparator<T> cc){
        if (a.size() <= 1) return ;

        Random RND = new Random();

        List<T> lt = new ArrayList<>(),
                eq = new ArrayList<>(),
                gt = new ArrayList<>();

        T p = a.get(RND.nextInt(a.size()));
        for (T elt: a) {
            if (cc.compare(elt, p) < 0) lt.add(elt);
            else if (cc.compare(elt, p)  == 0) eq.add(elt);
            else gt.add(elt);
        }

        quickSortHelper(lt, cc); quickSortHelper(gt, cc);
        a.clear();
        a.addAll(lt); a.addAll(eq); a.addAll(gt);
    }
    /**
     * should run in O(nlogn) time in the worst case.
     */
    static <T> void mergeInto(T[] a, T[] b, T[] out, Comparator<T> cc) {
        int i = 0, j = 0;
        for (int o=0; o < out.length; o++) {
            if (i >= a.length) // run out of a
                out[o] = b[j++];
            else if (j >= b.length)
                out[o] = a[i++];
            else if (cc.compare(a[i], b[j]) <= 0)
                out[o] = a[i++];
            else
                out[o] = b[j++];
        }
    }
    static <T> void mergeSort(T[] array, Comparator<T> cc){
        int n = array.length;
        if (n <= 1) return;

        T[] left = Arrays.copyOfRange(array, 0, n/2);
        T[] right = Arrays.copyOfRange(array, n/2, n);

        mergeSort(left, cc); mergeSort(right, cc);
        mergeInto(left, right, array, cc);
    }
}


