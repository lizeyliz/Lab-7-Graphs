public class Edge {
    private Vertex start; //start vertex
    private Vertex end; //end vertex
    private Integer weight; //weight of the edge
      
    public Edge(Vertex startV, Vertex endV, Integer inputWeight) { //constructor
      this.start = startV;
      this.end = endV;
      this.weight = inputWeight;
    }
      
    public Vertex getStart() { //getter method
      return this.start;
    }
      
    public Vertex getEnd() { //getter method
      return this.end;
    }
      
    public Integer getWeight() { //getter method
      return this.weight;
    }
      
  }