import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastDateClient {
    public static void main(String[] args) throws IOException {
        MulticastSocket socket = new MulticastSocket(1313); // Corrected port to match the server
        InetAddress group = InetAddress.getByName("230.0.0.1");
        socket.joinGroup(group);
        // create a multicast socket and join a group

        for (int i = 0; i < 10; i++) {
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            // empty packet to receive group data

            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Current server time: " + received);
            // print the answer
        }

        socket.leaveGroup(group);
        socket.close();
    }
}
