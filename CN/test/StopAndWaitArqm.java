import java.util.Random;

class Sender extends Thread {
    private final Channel channel;
    private int frameToSend = 0;

    public Sender(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            // Send the frame
            System.out.println("Sender: Sending frame " + frameToSend);
            channel.send(frameToSend);

            // Simulate waiting for acknowledgment
            try {
                Thread.sleep(1000); // Simulate the delay in real-world scenario
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Check for acknowledgment
            if (channel.isAckReceived(frameToSend)) {
                System.out.println("Sender: Acknowledgment received for frame " + frameToSend);
                frameToSend = (frameToSend + 1) % 2; // Alternate between 0 and 1
            } else {
                System.out.println("Sender: No acknowledgment, resending frame " + frameToSend);
            }
        }
    }
}

class Receiver extends Thread {
    private final Channel channel;
    private int expectedFrame = 0;

    public Receiver(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            int receivedFrame = channel.receive();
            if (receivedFrame == expectedFrame) {
                System.out.println("Receiver: Received expected frame " + receivedFrame);
                channel.sendAck(expectedFrame);
                expectedFrame = (expectedFrame + 1) % 2; // Alternate between 0 and 1
            } else {
                System.out.println("Receiver: Received unexpected frame " + receivedFrame);
                // Resend acknowledgment for the last correctly received frame
                channel.sendAck((expectedFrame + 1) % 2);
            }
        }
    }
}

class Channel {
    private int sentFrame = -1;
    private int receivedAck = -1;

    public synchronized void send(int frame) {
        sentFrame = frame;
        notifyAll();
    }

    public synchronized int receive() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sentFrame;
    }

    public synchronized void sendAck(int frame) {
        receivedAck = frame;
        notifyAll();
    }

    public synchronized boolean isAckReceived(int frame) {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return receivedAck == frame;
    }
}

public class StopAndWaitArqm {
    public static void main(String[] args) {
        Channel channel = new Channel();
        Sender sender = new Sender(channel);
        Receiver receiver = new Receiver(channel);

        sender.start();
        receiver.start();
    }
}
