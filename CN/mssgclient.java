import java.util.*;
import java.net.*;
import java.io.*;

public class mssgclient {

    public static void main(String args[]){
        try{
            Socket s = new Socket("localhost",6666);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("HEllo server");
            dos.flush();//buffer
            dos.close();
            s.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
