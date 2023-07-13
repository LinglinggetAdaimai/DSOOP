import java.util.*;

class UndirectedAdjMap<Vertex> implements UndirectedGraph<Vertex> {
    private Map<Vertex, Set<Vertex>> graph;

    UndirectedAdjMap() {
        graph = new HashMap<>();
    }

    /**
     * How many edges?
     */
    @Override
    public int numEdges() {
        int result =  0;
        for(Vertex temp: graph.keySet() ){
            result += graph.get(temp).size();
        }
        return result;
    }

    /**
     * How many vertices?
     */
    @Override
    public int numVertices() {
        return graph.size();
    }

    /** Return the degree of v */
    /**
     * Return an iterable of vertices adjacent to v
     */
    @Override
    public int deg(Vertex v) {
        if (graph.containsKey(v)){ return graph.get(v).size();}
        return 0;
    }

    /**
     * Is there an edge between u and v?
     */
    @Override
    public Iterable<Vertex> adj(Vertex v) {
        return graph.get(v);
    }

    /**
     * Is there an edge between u and v?
     */
    @Override
    public boolean isEdge(Vertex u, Vertex v) {
        return graph.containsKey(u) && graph.get(u).contains(v);
    }

    /**
     * Add a new vertex
     */
    @Override
    public void addVertex(Vertex v) {
        graph.put(v, new HashSet<>());
    }

    /**
     * Add an edge between u and v
     */
    @Override
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

    /**
     * Remove an edge
     */
    @Override
    public void removeEdge(Vertex u, Vertex v) {
        if (graph.containsKey(u)) graph.get(u).remove(v);
    }
}

public class BFS {

    public static Map<Integer, Integer> nbrs(UndirectedGraph<Integer> G, Set<Integer> F) {
        Map<Integer, Integer> nbrSet = new HashMap<>();
        for (Integer src: F) {
            for (Integer dst: G.adj(src))
                nbrSet.put(dst, src);
            }
        return nbrSet;
    }

    public static Map<Integer, Integer> bfs(UndirectedGraph<Integer> G, Integer s) {
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
    static void findShortest(UndirectedGraph<Integer> G, Integer a, Integer b) {
        // get the Map<dst, src> starting from a
        // trace back from b
        // print out the path backwards
        Map<Integer, Integer> bfsMap = bfs(G,a);
        LinkedList<Integer> returnlist = new LinkedList<>();

        Integer curr = b;
        returnlist.add(curr);

        while (!curr.equals(a)){
            Integer par = bfsMap.get(curr);
            returnlist.addFirst(par); curr = par;
        }
        toString(returnlist);
    }

    public static void toString(LinkedList<Integer> list){
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
