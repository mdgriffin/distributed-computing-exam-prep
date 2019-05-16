package q1.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;

public class Receiver {

    private static final int MAX_LEN = 20;
    private static final int PORT_NUM = 9900;

    public static void main(String[] args) {
        try {
            DatagramSocket mySocket = new DatagramSocket(PORT_NUM);

            // Receiving from client
            byte[] buffer = new byte[MAX_LEN];
            DatagramPacket datagram = new DatagramPacket(buffer, MAX_LEN);
            mySocket.receive(datagram); // blocking
            System.out.println(new String(buffer));

            // Responding to the client
            byte[] response = "Hello From Server".getBytes();
            mySocket.send(new DatagramPacket(response, response.length, datagram.getAddress(), datagram.getPort()));

            mySocket.close();
        }
        catch (SocketTimeoutException ex) {
            System.out.println("Socket Has Timed Out");
        }
        catch (Exception ex) {
            ex.printStackTrace( );
        }
    }
}