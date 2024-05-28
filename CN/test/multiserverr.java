import java.util.*;
import java.net.*;
import java.io.*;

public class multiserverr {
    public static void main(String args[]) throws IOException, InterruptedException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress group = InetAddress.getByName("224.0.0.1");
        socket.setSoTimeout(1000);
        for (int i = 0; i < 10; i++) {
            byte[] buf = new Date().toString().getBytes();
            DatagramPacket p = new DatagramPacket(buf, buf.length, group, 1234);
            socket.send(p);
            Thread.sleep(1000);
        }
        socket.close();
    }
}
