import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Classlessnet{
    
    public static void main(String[] args) {
        String input = "106.200.200.200/24";
        String[] parts = input.split("/");
        String ipAddress = parts[0];
        int prefixLength = Integer.parseInt(parts[1]);
        
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            byte[] ipBytes = inetAddress.getAddress();
            byte[] netmaskBytes = getNetmask(prefixLength);
            byte[] networkBytes = new byte[4];
            byte[] hostBytes = new byte[4];
            
            // Calculate network address
            for (int i = 0; i < 4; i++) {
                networkBytes[i] = (byte) (ipBytes[i] & netmaskBytes[i]);
            }
            
            // Calculate host ID
            for (int i = 0; i < 4; i++) {
                hostBytes[i] = (byte) (ipBytes[i] & ~netmaskBytes[i]);
            }
            
            InetAddress networkAddress = InetAddress.getByAddress(networkBytes);
            InetAddress hostAddress = InetAddress.getByAddress(hostBytes);
            
            System.out.println("IP Address: " + ipAddress);
            System.out.println("Subnet Mask: " + prefixLength);
            System.out.println("Network Address: " + networkAddress.getHostAddress());
            System.out.println("Host ID: " + Arrays.toString(hostBytes));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    
    // Helper method to get netmask from prefix length
    private static byte[] getNetmask(int prefixLength) {
        byte[] netmask = new byte[4];
        for (int i = 0; i < prefixLength; i++) {
            netmask[i / 8] |= (1 << (7 - (i % 8)));
        }
        return netmask;
    }
}
