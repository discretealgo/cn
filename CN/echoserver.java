import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class echoserver {
    public static final int bufsize = 80;

    public static void main(String args[]) throws IOException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Usage: java Echoserver <Port>");
        }

        int servPort = Integer.parseInt(args[0]);
        try (ServerSocket servsock = new ServerSocket(servPort)) {
            System.out.println("Echo server listening on port " + servPort);

            while (true) {
                Socket sock = servsock.accept();
                System.out.println("Accepted connection from " + sock.getInetAddress());

                InputStream in = sock.getInputStream();
                OutputStream out = sock.getOutputStream();

                int bytesRead;
                byte[] byteBuffer = new byte[bufsize];
                while ((bytesRead = in.read(byteBuffer)) != -1) {
                    out.write(byteBuffer, 0, bytesRead);
                }

                sock.close();
                System.out.println("Connection closed.");
            }
        }
    }
}



/*java echoserver 1235
 */