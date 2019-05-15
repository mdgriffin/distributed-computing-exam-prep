package q2;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceiverThread implements  Runnable {

    private static final int MAX_LEN = 100;
    private InetAddress group;
    private int port;
    private boolean running = true;

    public ReceiverThread (InetAddress group , int port) {
        this.group = group;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            MulticastSocket socket = new MulticastSocket(port);
            socket.joinGroup(group);

            while(running) {
                byte[] data = new byte[MAX_LEN];
                DatagramPacket packet = new DatagramPacket(data, data.length, group, port);
                socket.receive(packet);

                String s = new String(packet.getData());
                System.out.println("Received by Thread: " + s);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void stop () {
        this.running = false;
    }
}