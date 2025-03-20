import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //initialize
        Scanner scan = new Scanner(System.in);
        Bus_Station bus = new Bus_Station();
        //link vertexes
        bus.createBusNetwork();
        //call user menu on the bus network graph created in bus station class
        bus.busNetwork.userMenu(scan);
        
    }//end main method
}//end class main
