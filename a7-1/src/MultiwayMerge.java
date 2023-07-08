import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MultiwayMerge {
    /**
     * Combine lists in sorted order small to large
     * run in O(N log k); N is the sum of the list lengths and k = lists.length
     */

    static class ListComparator implements Comparator<LinkedList<Integer>> {
        @Override
        public int compare(LinkedList<Integer> o1, LinkedList<Integer> o2) {
            return o1.getFirst() > o2.getFirst() ? 1 : -1;
        }
    }

    public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists){
        PriorityQueue<LinkedList<Integer>> listpq = new PriorityQueue<>(new ListComparator());
        for (LinkedList<Integer> list: lists){ // put every list that contains smth in the pq
            if (list.size() !=  0) listpq.add(list);
        }
        LinkedList<Integer> returnedlist = new LinkedList<>();

        // loop untill all the elements get put in the returned linkedlist
            // THELIST variable stores the list that has the smallest first index, by poll. (delete the that list from the pq)
            // remove the first index from THELIST and put it in the returned linkedlist.
            // if there is any element left in the THELIST then add it into pq
        while (!listpq.isEmpty()) {
            LinkedList<Integer> THELIST = listpq.poll();
            returnedlist.add(THELIST.removeFirst());
            if (THELIST.size() != 0) listpq.add(THELIST);
        }
        return returnedlist;
    }
}
