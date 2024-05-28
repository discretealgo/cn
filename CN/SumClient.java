import java.io.*;
import java.net.*;

public class SumClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 1234;
        
        try (Socket socket = new Socket(hostname, port)) {
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());
            
            // Send two numbers to the server
            int num1 = 10;
            int num2 = 20;
            
            output.writeInt(num1);
            output.writeInt(num2);
            
            // Read the sum from the server
            int sum = input.readInt();
            
            System.out.println("Sent numbers: " + num1 + " and " + num2);
            System.out.println("Received sum: " + sum);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
