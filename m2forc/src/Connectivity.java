import java.util.*;

class Node implements Comparator<Node>{
    int start, end, weight ;
    Node(){}
    Node(int[] n){start = n[0]; end = n[1]; weight = n[2];}

    @Override
    public int compare(Node o1, Node o2) {
        return o1.weight > o2.weight ? 1:-1;
    }
}

public class Connectivity {

    public static int optimize(int numIslands, int[][] cablingCost, int budget) {
        // storing the islands' info
        PriorityQueue<Node> islands = new PriorityQueue<>(new Node());
        int numIso = numIslands; // number of isolated island

        // put island into the queue O(n logn)
        for (int i = 0; i < cablingCost.length; i++){
            int[] currNode = cablingCost[i];
            islands.add(new Node(currNode));
        }

        int currBud = 0; // used budget
        Set<Integer> connected = new HashSet<>(); // store the island that alr been connected

        while (currBud < budget && numIso > 0){ // adding things up until we ran out of budget // O(n)
            Node island = islands.poll(); int weight = island.weight; // O(1)
            if ((currBud + weight) <= budget){
                currBud += weight;
                connected.add(island.start); connected.add(island.end); // O(1)
            }
            else break;
        }
        return numIso - connected.size();
    }

    public static void main(String[] args) {

        int[][] cablings = {
                {0, 2, 19},
                {1, 0, 25},
                {3, 1, 10},
                {3, 4, 9},
                {2, 4, 12},
                {1, 2, 2},
        };
        System.out.println(optimize(
                5,
                cablings,
                9
        ));
      /* another example:
       int[][] cablings = {
           {0, 1, 3},
           {1, 2, 2}
       };
       System.out.println(optimize(
               3,
               cablings,
               1
       ));
    */
    }
}
