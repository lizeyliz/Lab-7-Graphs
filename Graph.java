import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
    //instance variables
    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;//pointing one way
    

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

    //hel[er method to chose which station from user input
    public Vertex chooseStation(Scanner input) {
        System.out.println("Please choose a station: ");
        for (int i = 0; i < this.vertices.size(); i++) {
            System.out.println((i + 1) + ". " + this.vertices.get(i).getData());
        }
        int choice = input.nextInt();
        if (choice < 1 || choice > this.vertices.size()) {
            System.out.println("Invalid choice. Please try again.");
            chooseStation(input);
        } else {
            switch (choice) {
                case 1: return this.vertices.get(0); //downtown
                case 2: return this.vertices.get(1); //cordata
                case 3: return this.vertices.get(2); //Sunset
                case 4: return this.vertices.get(3); //Meridian
                case 5: return this.vertices.get(4); //Bellis fair
                case 6: return this.vertices.get(5); //Lummi
                case 7: return this.vertices.get(6); //Fairhaven
                case 8: return this.vertices.get(7); //Samish
                case 9: return this.vertices.get(8); //Ferndale
                case 10: return this.vertices.get(9); //Barkley
            
                default: return null;
            }
        }
        return null;

    }

    //depth first search: takes in start vertex and array to hold the DFS order: NEED TO CHECK
    public void depthFirstSearch(Vertex start) {
        ArrayList<Vertex> DFS = new ArrayList<>();//holds depth first search
        Stack<Vertex> stack = new Stack<Vertex>();//stack so we can backtrack (imitates recursion)
        ArrayList<Vertex> visited = new ArrayList<>();
        
        //push start node into stack
        stack.push(start);
        //put start into the visited ArrayList
        visited.add(start);
        //while stack not empty
        while (!stack.isEmpty()) {
            Vertex curr = stack.pop();//visit current node
            DFS.add(curr);//add it to DFS ARRAYLIST
            
            //push unvisited adjacent vertices to stack
            for(Edge e: curr.getEdges()){ //for each edge connected to the current vertex
                Vertex neighbor = e.getEnd(); //returns the end vertex of the edge
                if(!visited.contains(neighbor)) { //if the neighbor is not already visited
                    stack.push(neighbor);//add it to stack
                    visited.add(neighbor); //add it to the visited list
                }//end if statement
            }//end for loop
        }//end while loop

        //print the depth first search by traversing DFS array
        System.out.println("Depth-First Search:");
        for(Vertex v: DFS) {//traverse DFS
            System.out.println(v.getData());
        }//end for loop
    }//end depthFirstSearch

    //bfs method
    public void breadthFirstSearch(Vertex start) {
        Queue<Vertex> bfsQueue = new LinkedList<>(); 
        ArrayList<Vertex> visited = new ArrayList<>();//fix this later
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
    
	

    

