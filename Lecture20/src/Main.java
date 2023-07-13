public class Main {

    public static void main(String[] args) {
        UndirectedGraph<Integer> graph = new UndirectedAdjMap<>();
        graph.addEdge(1,3);
        graph.addEdge(3,2);
        graph.addEdge(3,0);
        graph.addEdge(0,2);

        BFS.findShortest(graph, 2,1);

    }
}
