import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prep {
    static class UndirectedAdjMap<Vertex> {
        private Map<Vertex, Set<Vertex>> graph;

        UndirectedAdjMap() {
            graph = new HashMap<>();
        }

        /**
         * How many edges?
         */
        public int numEdges() {
            int result =  0;
            for(Vertex temp: graph.keySet() ){
                result += graph.get(temp).size();
            }
            return result;
        }
        public int getnumEdges(int j){
            if (graph.containsKey(j)) return graph.get(j).size();
            return 0;
        }

        /**
         * How many vertices?
         */
        public int numVertices() {
            return graph.size();
        }

        /** Return the degree of v */
        /**
         * Return an iterable of vertices adjacent to v
         */
        public int deg(Vertex v) {
            if (graph.containsKey(v)){ return graph.get(v).size();}
            return 0;
        }

        /**
         * Is there an edge between u and v?
         */
        public Iterable<Vertex> adj(Vertex v) {
            return graph.get(v);
        }

        /**
         * Is there an edge between u and v?
         */
        public boolean isEdge(Vertex u, Vertex v) {
            return graph.containsKey(u) && graph.get(u).contains(v);
        }

        /**
         * Add a new vertex
         */
        public void addVertex(Vertex v) {
            graph.put(v, new HashSet<>());
        }

        /**
         * Add an edge between u and v
         */
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
        public void removeEdge(Vertex u, Vertex v) {
            if (graph.containsKey(u)) graph.get(u).remove(v);
        }
    }
}
