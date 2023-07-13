import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Find the shortes path from a to b
 *
 * Logic
 *  - init 2 sets
 *      - frontier: set to store neighbour of the vertex we're currently checking - useless
 *      - seen: Vtxs that we've walked past, this won't store duplicate
 *      - path: store the vtxes we've been through.
 *  - check if a adj. b???
 *      - yes then just print loey
 *      - no then add a to the set and start looping
 *  - while loop until frontier is empty
 *      - for loop through a neighbours
 *          - for loop through neighbours of a's neighbours
 *              - if contains b, add this neighbour to the
 *              - add its neighbour to the set
 */

public class Lecture20 implements UndirectedGraph<Integer> {
    Set<Integer> nbrs(UndirectedGraph<Integer> G, Set<Integer> F) {
        // goal: return the neighbors of F
        Set<Integer> nbrSet = new HashSet<>();
        for (Integer u: F) {
            for (Integer v: G.adj(u)) { // deg(u)
                nbrSet.add(v);   // O(1)
            }
        }
        return nbrSet;
    }
    public Set<Integer> bfs(UndirectedGraph<Integer> G, Integer s) {
        Set<Integer> frontier = new HashSet<>(List.of(s));
        Set<Integer> seen = new HashSet<>(List.of(s));

        while (!frontier.isEmpty()) {
            // N(frontier) \ seen
            frontier = nbrs(G, frontier); // ** SUM_{u in F} 1+ deg(u)
            frontier.removeAll(seen); // at most **
            // seen = seen U frontier
            seen.addAll(frontier); // at most **
        }
        return seen;
    }

    @Override
    public int numEdges() {
        return 0;
    }

    @Override
    public int numVertices() {
        return 0;
    }

    @Override
    public int deg(Integer v) {
        return 0;
    }

    @Override
    public Iterable<Integer> adj(Integer v) {
        return null;
    }

    @Override
    public boolean isEdge(Integer u, Integer v) {
        return false;
    }

    @Override
    public void addVertex(Integer v) {

    }

    @Override
    public void addEdge(Integer u, Integer v) {

    }

    @Override
    public void removeEdge(Integer u, Integer v) {

    }
}
