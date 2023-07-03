import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MultiwayMerge {
    /**
     * Combine lists in sorted order small to large
     * run in O(N log k); N is the sum of the list lengths and k = lists.length
     */
    public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists){
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
        LinkedList<Integer> returnlist = new LinkedList<>();
        mergeAllHelper(minPriorityQueue, lists,0, lists.length);
        while (!minPriorityQueue.isEmpty()) {
            int element = minPriorityQueue.poll();
            returnlist.add(element);
        }
        return returnlist;
    }
    public static void mergeAllHelper(
            PriorityQueue<Integer> priorityQueue, LinkedList<Integer>[] lists, int start, int end) {
        int len = end - start, mid = (start+end)/2;
        if (len <= 1) priorityQueue.addAll(lists[start]);
        else {
            mergeAllHelper(priorityQueue, lists, start, mid);
            mergeAllHelper(priorityQueue, lists, mid, end);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> LL1 = new LinkedList<>();
        LL1.addAll(List.of(9,10,11,13,17));

        LinkedList<Integer> LL2 = new LinkedList<>();
        LL2.addAll(List.of(1,2,5));

        LinkedList<Integer> LL3 = new LinkedList<>();

        LinkedList<Integer> LL4 = new LinkedList<>();
        LL4.addAll(List.of(0));

        LinkedList<Integer> LL5 = new LinkedList<>();
        LL5.addAll(List.of(3,7));

        int arraysize = 5;

        LinkedList<Integer>[] lists = (LinkedList<Integer>[]) new LinkedList<?>[arraysize];

        lists[0] = LL1;
        lists[1] = LL2;
        lists[2] = LL3;
        lists[3] = LL4;
        lists[4] = LL5;
        LinkedList<Integer> returnlist  = mergeAll(lists);
        int size = returnlist.size(), i = 0;
        while (i<size){
            System.out.println(returnlist.get(i++));
        }
    }


}
