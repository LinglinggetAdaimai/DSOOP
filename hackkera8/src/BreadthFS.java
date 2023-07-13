import java.util.*;
public class BreadthFS {
static class UndirectedAdjMap<Vertex> {
    private Map<Vertex, Set<Vertex>> graph;

    UndirectedAdjMap() {
        graph = new HashMap<>();
    }
    public int getnumEdges(int j){
        if (graph.containsKey(j)) return graph.get(j).size();
        return 0;
    }

    public Iterable<Vertex> adj(Vertex v) {
        return graph.get(v);
    }
    public void addVertex(Vertex v) {
        graph.put(v, new HashSet<>());
    }
    public void addEdge(Vertex u, Vertex v) {
        if (graph.containsKey(u)) {
            if (graph.containsKey(v)) {
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            else {
                addVertex(v);
                addEdge(u, v);
            }
        } else {
            addVertex(u);
            addVertex(v);
            addEdge(u, v);
        }
    }
    public boolean isEdge(Vertex u, Vertex v) {
        return graph.containsKey(u) && graph.get(u).contains(v);
    }
}

//static class BFS {
//
//    public static Set<Integer> nbrs(UndirectedAdjMap<Integer> G, Set<Integer> F) {
//        Set<Integer> nbrSet = new HashSet<>();
//        for (Integer src : F) {
//            for (Integer dst : G.adj(src))
//                nbrSet.add(dst);
//        }
//        return nbrSet;
//    }
//
//    public static int[] bfs(UndirectedAdjMap<Integer> G, Integer s, Integer n) {
//        Set<Integer> frontier = new HashSet<>();
//        Set<Integer> visited = new HashSet<>();
//        int p[] = new int[n+1];
//        frontier.add(s);
//        visited.add(s);
//        int count = 0;
//        while (!frontier.isEmpty()) {
//            count++;
//            frontier = nbrs(G, frontier);
//
//            frontier.removeAll(visited);
//            for (Integer ele: frontier){
//                p[ele] = count;
//            }
//            visited.addAll(frontier);
//        }
//        return p;
//    }
//}
//    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
//        UndirectedAdjMap <Integer> map = new UndirectedAdjMap<>();
//        List<Integer> returnedList = new ArrayList<>();
//        for (List<Integer> pair: edges) {
//            map.addEdge(pair.get(0), pair.get(1));
//        }
//        int[] p = BFS.bfs(map,s,n);
//        for (int j = 1; j <= n; j++){
//            if (j==s){continue;}
//            if (p[j] == 0) {returnedList.add(-1);}
//            else returnedList.add(p[j]*6);
//        }
//        return returnedList;
//    }
    static class BFS {

        public static Map<Integer, Integer> nbrs(UndirectedAdjMap<Integer> G, Set<Integer> F) {
            Map<Integer, Integer> nbrSet = new HashMap<>();
            for (Integer src: F) {
                for (Integer dst: G.adj(src))
                    nbrSet.put(dst, src);
            }
            return nbrSet;
        }

        public static Map<Integer, Integer> bfs(UndirectedAdjMap<Integer> G, Integer s) {
            Map<Integer, Integer> frontier = new HashMap<>();
            Map<Integer, Integer> visited = new HashMap<>();
            frontier.put(s, null); visited.put(s, null);
            while (!frontier.isEmpty()) {
                frontier = nbrs(G, frontier.keySet()); // nbrs(frontier) - visited
                frontier.keySet().removeAll(visited.keySet());
                visited.putAll(frontier);
            }
            return visited;
        }
        public static int findShortest(UndirectedAdjMap<Integer> G, Integer a, Integer b) {
            // get the Map<dst, src> starting from a
            // trace back from b
            // print out the path backwards
            Map<Integer, Integer> bfsMap = bfs(G,a);
            LinkedList<Integer> returnlist = new LinkedList<>();

            Integer curr = b;
            returnlist.add(curr);
            int count = 0;
            while (!curr.equals(a)){
                Integer par = bfsMap.get(curr);
                count++; curr = par;
            }
            return count;
        }
    }
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        UndirectedAdjMap <Integer> map = new UndirectedAdjMap<>();
        List<Integer> returnedList = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            map.addVertex(i);
        }
        for (List<Integer> pair: edges) {
            map.addEdge(pair.get(0), pair.get(1));
        }
        int egdes = 0;
        for (int j = 1; j <= n; j++){
            if (j == s) continue;
            if (map.getnumEdges(j) == 0){returnedList.add(-1);}
            else {
                if (map.isEdge(s,j)) returnedList.add(6);
                else {
                    egdes = BFS.findShortest(map, s, j);
                    returnedList.add(egdes * 6);
                }
            }
        }
        return returnedList;
    }

}
