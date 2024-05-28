import java.io.*;
import java.net.*;

public class stringclient {
    public static void main(String[] args) {
        try {
            String sentence, modifiedSentence;
            System.out.println("Enter the sentence:");
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            Socket clientSocket = new Socket("localhost", 1234);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + "\n");
            modifiedSentence = inFromServer.readLine();
            System.out.println("From server: " + modifiedSentence);
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
