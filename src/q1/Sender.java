package q1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {

    private static final int MAX_LEN = 20;

    public static void main(String[] args) {
        try {
            InetAddress receiverHost = InetAddress.getByName("localhost");
            int receiverPort = 9900;

            // Bind to any available port
            DatagramSocket mySocket = new DatagramSocket();

            // Sending the message to q1.Receiver
            byte[] buffer = "Hello From Client".getBytes( );
            DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort);
            mySocket.send(datagram);

            // Receiving Response from the q1.Receiver
            byte[] responseBuffer = new byte[MAX_LEN];
            DatagramPacket receiverResponse = new DatagramPacket(responseBuffer, MAX_LEN);
            mySocket.receive(receiverResponse);
            System.out.println(new String(responseBuffer));

            mySocket.close( );
        } catch (Exception ex) {
            ex.printStackTrace( );
        }
    }
}