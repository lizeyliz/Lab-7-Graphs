import java.lang.classfile.ClassFile;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Scanner;
public class AlizaMethods {
    Graph graph = new Graph(true, false);
    Bus_Station station = new Bus_Station();
    Scanner scan = new Scanner(System.in);



    //depth first search: takes in start vertex and array to hold the DFS order
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
}//end AlizaMethods
