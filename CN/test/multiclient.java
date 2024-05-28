import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class multiclient {
    public static void main(String[] args) {
        try {
            MulticastSocket ms = new MulticastSocket(1234);
            InetAddress group = InetAddress.getByName("224.0.0.1"); // Valid multicast address
            ms.joinGroup(group);

            for (int i = 0; i < 10; i++) {
                byte[] buf = new byte[256];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                ms.receive(dp);

                // Convert received data to a string
                String received = new String(dp.getData(), 0, dp.getLength());
                System.out.println("Received: " + received);
            }

            ms.leaveGroup(group);
            ms.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
