import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class MulticastDateServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket socket = new DatagramSocket();
        // create socket

        for (int i = 0; i < 10; i++) {
            byte[] buf = new Date().toString().getBytes();
            // prepare data to send
            InetAddress group = InetAddress.getByName("230.0.0.1");
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 1313);
            socket.send(packet);
            // send a packet to a multicast group address and a port

            Thread.sleep(1500);
        }

        socket.close();
    }
}
