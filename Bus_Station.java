public class Bus_Station {

    //create bus stops

    public void createBusNetwork() {
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

    
    

    

    
    
}
