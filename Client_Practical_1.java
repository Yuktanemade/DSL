import java.sql.*; 
import java.rmi.*; 
import java.io.*; 
import java.util.*; 
import java.rmi.registry.*;

public class Client_Practical_1 {
    static String name1, name2, name3;

    public static void main(String args[]) {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int ch;
        try {
            // Connect to the registry on localhost at port 1030
            Registry r1 = LocateRegistry.getRegistry("localhost", 1030);
            // Lookup the remote object
            DBInterface DI = (DBInterface) r1.lookup("DBServ");
            
            do {
                System.out.println("1. Send input strings\n2. Display concatenated string\nEnter your choice:");
                ch = Integer.parseInt(b.readLine());
                
                switch (ch) {
                    case 1:
                        // Input strings
                        System.out.println("Enter first string:");
                        name1 = b.readLine();
                        System.out.println("Enter second string:");
                        name2 = b.readLine();
                        // Call the remote method to concatenate strings
                        name3 = DI.input(name1, name2);
                        break;
                        
                    case 2:
                        // Display concatenated string
                        System.out.println("Concatenated String is: " + name3);
                        break;
                        
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (ch > 0);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
