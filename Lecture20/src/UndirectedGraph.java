public interface UndirectedGraph<Vertex> {
    int numEdges(); /** How many edges? */
    int numVertices(); /** How many vertices? */
    int deg(Vertex v); /** Return the degree of v */
    /** Return an iterable of vertices adjacent to v */
    Iterable<Vertex> adj(Vertex v);
    /** Is there an edge between u and v? */
    boolean isEdge(Vertex u, Vertex v);
    /** Add a new vertex */
    void addVertex(Vertex v);
    /** Add an edge between u and v */
    void addEdge(Vertex u, Vertex v);
    /** Remove an edge */
    void removeEdge(Vertex u, Vertex v); }