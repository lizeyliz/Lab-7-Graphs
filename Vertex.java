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

    //takes in end vertex and weight
    public void addEdge(Vertex endVertex, Integer weight) {
        this.edges.add(new Edge(this, endVertex, weight));
    }

    public void removeEdge(Vertex endVertex) {
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    public ArrayList<Edge> getEdges(){
        return this.edges;
    }
}