
import java.io.*;
import java.util.*;
import java.net.*;


public class mssgserver {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream ds = new DataInputStream(s.getInputStream());
            String str=(String)ds.readUTF();
            System.out.println(str);
            ss.close();



        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
