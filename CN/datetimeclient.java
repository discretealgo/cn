import java.io.*;
import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class datetimeclient {
    public static void main(String args[]){
        try{
            Socket s = new Socket("localhost",9999);
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            SimpleDateFormat f1 = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
            Date d = new Date();
            dos.writeUTF(f1.format(d));
            dos.flush();
            dos.close();
            s.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
