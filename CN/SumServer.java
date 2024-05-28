import java.io.*;
import java.net.*;

public class SumServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is listening on port 1234");
            
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connected");
                    
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                    
                    // Read two numbers from the client
                    int num1 = input.readInt();
                    int num2 = input.readInt();
                    
                    // Calculate the sum
                    int sum = num1 + num2;
                    
                    // Send the sum back to the client
                    output.writeInt(sum);
                    
                    System.out.println("Received numbers: " + num1 + " and " + num2);
                    System.out.println("Sent sum: " + sum);
                    serverSocket.close();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
