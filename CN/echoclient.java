import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class echoclient {
    public static void main(String args[]) throws IOException {
        if (args.length < 2 || args.length > 3) {
            throw new IllegalArgumentException("Usage: java Echoclient <server> <word> [<port>]");
        }

        String server = args[0];
        byte[] byteBuffer = args[1].getBytes();
        int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 1235;

        try (Socket echoSocket = new Socket(server, servPort)) {
            System.out.println("Connected to server... sending data");

            InputStream in = echoSocket.getInputStream();
            OutputStream out = echoSocket.getOutputStream();

            out.write(byteBuffer);

            int totalBytesRcvd = 0;
            int bytesRcvd;
            while (totalBytesRcvd < byteBuffer.length) {
                if ((bytesRcvd = in.read(byteBuffer, totalBytesRcvd, byteBuffer.length - totalBytesRcvd)) == -1) {
                    throw new SocketException("Connection closed prematurely");
                }
                totalBytesRcvd += bytesRcvd;
            }

            System.out.println("Received: " + new String(byteBuffer));
        } // The socket will be automatically closed when exiting the try block
    }
}




















/*java echoclient localhost "Hello, server!" 1235
 */
