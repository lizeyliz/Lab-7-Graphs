import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Graph {
    //instance variables
    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;//pointing one way
    private ArrayList<Vertex> visited = new ArrayList<>();//fix this later

    //constructor
    public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    //creates a new vertex with given data and adds it to the vertices ArrayList
    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    //add an edge between two vertices, gives it a weight: takes in two vertices and weight
    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        if (!this.isWeighted) {//if this istance of graph class not weighted, weight is null
            weight = null;
        }
        vertex1.addEdge(vertex2, weight);//calling addEdge method from Vertex class
        if (!this.isDirected) {//if it's not pointing only one way
        vertex2.addEdge(vertex1, weight);//add another edge pointing the other way
        }
    }

    //remove an edge: takes in two vertexes
    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.removeEdge(vertex2);

        if (!this.isDirected) {//if it points two ways
        vertex2.removeEdge(vertex1);
        }
    }

    //removes vertex from the list
    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    //getters
    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }

    public boolean isWeighted() {
        return this.isWeighted;
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public Vertex getVertexByValue(String value) {
        for(Vertex v: this.vertices) { 
            if (v.getData() == value) {
                return v;
            }
        }

        return null;
    }
	
    //print method
    public void print() {
        for(Vertex v: this.vertices) {
            v.print(isWeighted);//calling print method from vertex class
        }
    }

    
    //bfs method
    public void breathFirstSearch(Vertex start) {
        Queue<Vertex> bfsQueue = new LinkedList<>(); 
        bfsQueue.add(start); //add the starting vertex to the queue
        visited.add(start); //add the starting vertex to the visited list

        System.out.println("BFS: ");
        System.out.println(start.getData()); //print the data of the starting vertex

        while(!bfsQueue.isEmpty()) { //while the queue is not empty
            Vertex curr = bfsQueue.poll(); //retreives and removes the head element of a queue
            
            for(Edge e: curr.getEdges()){ //for each edge in the current vertex
                Vertex neighbor = e.getEnd(); //returns the end vertex of the edge
                if(!visited.contains(neighbor)) { //if the neighbor is not already visited
                    visited.add(neighbor); //add it to the visited list
                    bfsQueue.add(neighbor); //add it to the queue
                    System.out.println(neighbor.getData()); //print the data of the current vertex
                }
            }

        }
        visited.clear(); //clear the visited list for the next search


    }
	
}
    
	

    

