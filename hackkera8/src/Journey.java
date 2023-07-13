import java.util.ArrayList;
import java.util.List;
public class Journey {

static class DJS {
        int[] p;
        int[] size;
        public DJS(int n) { // O(n)
            // [{0}, {1}, {2}, {3}, ... , {n-1} ]
            p = new int[n];
            size = new int[n];
            for (int i=0;i<n;i++) {
                p[i] = i;
                size[i] = 1;
            }
        }
        // which tribe does m belong to?
        int find(int m) { return p[m]; }
        // O(log* n)
        int root(int x) { // O(log n)
            if (p[x] != x)
                // path compression
                // return p[x] = root(p[x]);
                return root(p[x]);
            return x;
        }
        //  O(?)
        public boolean isConnected(int x, int y) {
            return root(x) == root(y);
        }
        // O(?)
        public void link(int x, int y) {
            int rootX = root(x), rootY = root(y);
            if (size[rootX] <= size[rootY]) {
                p[rootX] = rootY; // join x into y
                size[rootY] += size[rootX];
            }
            else {
                p[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        DJS edges = new DJS(n);
        int nojoints = n - astronaut.size()*2;
        for (List<Integer> pair: astronaut) {
            edges.link(pair.get(0), pair.get(1));
        }
        int ret = 1;
        for (int ele: edges.size){
            ret *= ele;
        }
        ret += nojoints/2;
        return ret ;

    }
}
