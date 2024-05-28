import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class currtimeclient{
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;
        
        try (Socket socket = new Socket(hostname, port)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = input.readLine();
            System.out.println("Current date and time from server: " + serverResponse);
        } catch (IOException e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
