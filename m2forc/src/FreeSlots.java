import java.util.*;
class Slot implements Comparator<Slot>{
    int slot;
    int peep;
    Slot(int s, int p){
        slot = s;
        peep = p;
    }
    Slot(){}

    @Override
    public int compare(Slot o1, Slot o2) {
        return o1.peep < o2.peep ? 1:-1;
    }
}

public class FreeSlots {
    public static List<String> topFreeSlots(int n, List<List<Integer>> occupied, int topK) {
        int numKit = occupied.size(); // n is the number of slot
        List<String> retStr = new ArrayList<>();

        // create array store, time slot is the index, how many people book at that time
        int[] p = new int[n];
        for (int i = 0; i < numKit; i++){
            for (int j = 0; j < occupied.get(i).size(); j ++){
                int currSlot = occupied.get(i).get(j);
                p[currSlot] = p[currSlot] +1;
            }
        }
        PriorityQueue<Slot> queue = new PriorityQueue<>(new Slot());
        for (int k = 0; k < p.length; k++){
            queue.add(new Slot(k, numKit - p[k]));
        }
        for (int a = 0; a < queue.size(); a++){
            Slot s = queue.poll();
            retStr.add(s.slot + "_" + s.peep);
        }

        return retStr; // todo: write me
    }

    public static void main(String[] args) {
        List<List<Integer>> occupied = List.of(
                List.of(3, 1, 2, 5),
                List.of(1, 0, 5),
                List.of(1, 2),
                List.of(2, 5)
        );
        List<String> top = topFreeSlots(6, occupied, 3);
        System.out.println(top.toString());

    }
}
