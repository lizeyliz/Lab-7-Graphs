import java.util.Scanner;

public class Bus_Station {
    Scanner input = new Scanner(System.in);
    //create bus stops
    Graph busNetwork = new Graph(true, false);

    //create bus stops
    Vertex DowntownStation = busNetwork.addVertex("Downtown Station");
    Vertex CordataStation = busNetwork.addVertex("Cordata Station");
    Vertex SunsetStation = busNetwork.addVertex("Sunset Station");
    Vertex MeridianStation = busNetwork.addVertex("Meridian Station");
    Vertex BellisFairStation = busNetwork.addVertex("Bellis Fair Station");
    Vertex LummiStation = busNetwork.addVertex("Lummi Nation Station");
    Vertex FairhavenStation = busNetwork.addVertex("Fairhaven Station");
    Vertex SamishStation = busNetwork.addVertex("Samish Station");
    Vertex FerndaleStation = busNetwork.addVertex("Ferndale Station");
    Vertex BarkleyStation = busNetwork.addVertex("Barkley Village Station");

    //add edges between the bus stops

    public void createBusNetwork() {

    busNetwork.addEdge(LummiStation, DowntownStation, 20);

    busNetwork.addEdge(DowntownStation, FairhavenStation, 15);
    busNetwork.addEdge(DowntownStation, SamishStation, 7);
    busNetwork.addEdge(DowntownStation, BellisFairStation, 10);

    busNetwork.addEdge(BellisFairStation, CordataStation, 5);
    busNetwork.addEdge(BellisFairStation, SunsetStation, 10);

    busNetwork.addEdge(SunsetStation, BarkleyStation, 5);
    busNetwork.addEdge(SunsetStation, MeridianStation, 10);

    busNetwork.addEdge(MeridianStation, CordataStation, 15);

    busNetwork.addEdge(CordataStation, FerndaleStation, 20);

    //print out graph
    System.out.println("Bus Network:");
    busNetwork.print();

    
    }

    //user menu
    public void userMenu(Scanner input){
        System.out.println("Welcome to the Bus Station menu!");
        System.out.println("Please select an option:");
        System.out.println("1. BFS Algorithm");
        System.out.println("2. DFS Algorithm");
        System.out.println("3. Dijkstra's Algorithm");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                Vertex g = busNetwork.chooseStation(input);
                busNetwork.breadthFirstSearch(g);
            
                break;
            case 2:
                System.out.println("You selected DFS Algorithm");
                break;
            case 3:
                System.out.println("You selected Dijkstra's Algorithm");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

    }

    
    

    

    
    
}
