import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
