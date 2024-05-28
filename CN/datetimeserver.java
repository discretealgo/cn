import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.io.*;
import java.net.*;
public class datetimeserver {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Server started");
            Socket s = serverSocket.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str=(String)dis.readUTF();
            System.out.println(str);
            serverSocket.close();
    }catch(Exception e){
        System.out.println(e);
    }


}
    
}
