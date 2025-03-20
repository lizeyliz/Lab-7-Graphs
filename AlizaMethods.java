import java.util.Stack;
public class AlizaMethods {
    //put all in constructor so it can be reinitialized each time
    private Vertex[] DFS = new Vertex[10];//array should be size of how many vertices there are
    private Vertex[] visited = new Vertex[10];

    //add to list of adjacent vertices each time you create an edge?

    //have to choose which vertex to start from?

    //depth first search: takes in start vertex and array to hold the DFS order
    //uses iteration with a stack
    void depthFirstSearch(Vertex start, Vertex[] DFS) {
        Stack<Vertex> stack = new Stack<Vertex>();//stack so we can backtrack (imitates recursion)
        boolean[] isVisited = new boolean[adjVertices.size()];//MAKE THIS WORK FOR YOUR PROGRAM
        //start from given node
        
        //push node into stack
        


        //while stack not empty
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Vertex> visited = new ArrayList<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            
            
            if(!isVisited[current]){
                isVisited[current] = true;
                visit(current);
                for (int dest : adjVertices.get(current)) {
                    if (!isVisited[dest])
                        stack.push(dest);
                }
        }
        return isVisited;

        for(Edge e: curr.getEdges()){ //for each edge in the current vertex
            Vertex neighbor = e.getEnd(); //returns the end vertex of the edge
            if(!visited.contains(neighbor)) { //if the neighbor is not already visited
                visited.add(neighbor); //add it to the visited list
                bfsQueue.add(neighbor); //add it to the queue
                System.out.println(neighbor.getData()); //print the data of the current vertex
            }
        }

            //mark current node as visited

            //visit current node

            //push unvisited adjacent vertices
    }
}
