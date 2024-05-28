import java.io.*;
import java.net.*;

public class stringserver {
    public static void main(String[] args) throws IOException {
        String clientSentence;
        String capitalizedSentence;
        try (ServerSocket welcomeSocket = new ServerSocket(1234)) {
            System.out.println("Server is listening on port 1234");
            while (true) {
                Socket connection = welcomeSocket.accept();
                System.out.println("Client connected");
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connection.getOutputStream());
                clientSentence = inFromClient.readLine();
                capitalizedSentence = clientSentence.toUpperCase() + "\n";
                outToClient.writeBytes(capitalizedSentence);
                System.out.println("Received from client: " + clientSentence);
                System.out.println("Sent to client: " + capitalizedSentence);
                connection.close();
            }
        }
    }
}
