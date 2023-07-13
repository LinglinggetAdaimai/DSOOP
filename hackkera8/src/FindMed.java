import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FindMed {
    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    /**
     * check if it's % by K
     */

    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        return arr.get(arr.size()/2);
    }
//    public static int qMed(List<Integer> arr, int k){
//        int len = arr.size();
//        if (len <= 1) return arr.get(0);
//
//
//        int pivot = arr.get(k);
//        List<Integer> lt = new ArrayList<>(),
//                eq = new ArrayList<>(),
//                gt = new ArrayList<>();
//        for (int elt: arr) {
//            if (elt < pivot) lt.add(elt);
//            else if (elt == pivot) eq.add(elt);
//            else gt.add(elt);
//        }
//        if(lt.size() > k) return qMed(lt, k);
//        else if (lt.size() == k) return pivot;
//        return qMed(gt, k-(lt.size())-2);
//    }
//
//    public static int qMed(List<Integer> arr, int k){
//        int len = arr.size();
//        if (len <= 1) return arr.get(0);
//        Random RND = new Random();
//        int indexRan = RND.nextInt(len);
//
//        int pivot = arr.get(indexRan);
//        List<Integer> lt = new ArrayList<>(),
//                eq = new ArrayList<>(),
//                gt = new ArrayList<>();
//
//        for (int elt: arr) {
//            if (elt < pivot) lt.add(elt);
//            else if (elt == pivot) eq.add(elt);
//            else gt.add(elt);
//        }
//
//        if(lt.size() > k) return qMed(lt, k);
//        else if (lt.size() == k) return pivot;
//        return qMed(gt, k-(lt.size())-2);
//    }



}
