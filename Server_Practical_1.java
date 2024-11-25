import java.rmi.*; 
import java.rmi.server.UnicastRemoteObject; 
import java.rmi.registry.LocateRegistry;
import java.sql.ResultSet;

interface DBInterface extends Remote {
    public String input(String name1, String name2) throws RemoteException;
}

public class Server_Practical_1 extends UnicastRemoteObject implements DBInterface {
    String name3;
    ResultSet r;

    public Server_Practical_1() throws RemoteException {
        try {
            System.out.println("Initializing Server\nServer Ready");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            // Create server instance and bind to registry
            Server_Practical_1 rs = new Server_Practical_1();
            LocateRegistry.createRegistry(1030).rebind("DBServ", rs);
            System.out.println("Server bound to registry on port 1030 as 'DBServ'");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Remote method implementation for concatenating two strings
    public String input(String name1, String name2) throws RemoteException {
        try {
            name3 = name1.concat(name2);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return name3;
    }
}
