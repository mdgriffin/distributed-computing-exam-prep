package q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSenderReceiver {
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        try {
            InetAddress group = InetAddress.getByName("239.1.2.3");
            int port = 8000;

            // Define a pool of receiver
            ReceiverThread[] receivers = new ReceiverThread[5];

            for (int i = 0; i < receivers.length; i++) {
                receivers[i] = new ReceiverThread(group, port);
                Thread thread = new Thread(receivers[i]);
                thread.start();
            }

            System.out.println("Enter Message (Return to close): ");
            String message = br.readLine();

            while (!message.equals("")) {
                byte[] data = message.getBytes();

                // Create Packet
                DatagramPacket packet = new DatagramPacket(data, data.length, group, port);
                MulticastSocket socket = new MulticastSocket(port);
                socket.setTimeToLive(1);
                socket.send(packet);
                socket.close();

                System.out.println("Enter Message (Return to close): ");
                message = br.readLine();
            }

            for (int i = 0; i < receivers.length; i++) {
                receivers[i].stop();
            }

            System.out.println("Goodbye!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
