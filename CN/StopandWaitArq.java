
import java.util.*;

public class StopandWaitArq {
    public static void main(String args[]) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 6; i++)
            data.add("Packet" + i);
        Sender sender = new Sender();
        // Receiver receiver = new Receiver();
        sender.SendData(data);
    }
}

class Receiver {
    int expectedSeqNum;

    public Receiver() {
        this.expectedSeqNum = 0;
    }

    Random random = new Random();

    public boolean ack(String packet, int SeqNum) {
        if (random.nextInt(100) < 20) {
            System.out.println("Receiver: " + packet + " Lost");
            return false;
        }
        if (expectedSeqNum == SeqNum) {
            System.out.println("Receiver: Acknowledgment for " + packet + " With Sequence Number " + SeqNum
                    + " Ack Number " + (expectedSeqNum + 1) % 2);
            expectedSeqNum = (expectedSeqNum + 1) % 2;
            return true;
        } else {
            System.out.println("Receiver: receives Duplicate packet");
            return false;
        }
    }
}

class Sender {
    Receiver receiver = new Receiver();
    int SeqNum;

    public Sender() {
        this.SeqNum = 0;
    }

    public void SendData(List<String> data) {
        for (String packet : data) {
            boolean ack = false;
            while (!ack) {
                System.out.println("Sender: sending " + packet + " with SeqNum " + SeqNum);
                ack = receiver.ack(packet, SeqNum);
            }
            if (ack) {
                System.out.println("Sender: Received acknowledgement for sequence number " + SeqNum);
                SeqNum = (SeqNum + 1) % 2;
            } else {
                System.out.println("Sender: Ack not received, resending packet");
            }
        }
        System.out.println("All data Sent");
    }
}

