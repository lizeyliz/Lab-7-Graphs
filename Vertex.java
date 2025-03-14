import java.util.ArrayList;

public class Vertex {
    //instance variables
    private String data; //data associated with a given vertex
    private ArrayList<Edge> edges; //arraylist to hold all edges

    //constructor
    public Vertex(String inputData) {
        this.data = inputData;
        this.edges = new ArrayList<Edge>();
    }

    //add an edge to a vertex: takes in end vertex and weight
    public void addEdge(Vertex endVertex, Integer weight) {
        this.edges.add(new Edge(this, endVertex, weight));//this calls the vertex object
    }

    //removes an edge(connection between two vertexes): called on a vertex object(start),takes in end vertex
    public void removeEdge(Vertex endVertex) {
        //removes if the end of the given vertex equals the parameter
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    //returns an instances of edges ArrayList
    public ArrayList<Edge> getEdges(){
        return this.edges;
    }
}