package q1.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramSocketWrapper extends DatagramSocket {

    static final int MAX_LEN = 100;

    DatagramSocketWrapper(int portNo)  throws SocketException {
        super(portNo);
    }

    DatagramSocketWrapper()  throws SocketException {
        super();
    }

    public void sendMessage(SocketMessage socketMessage) throws IOException {
        byte[] sendBuffer = socketMessage.getMessage().getBytes();
        DatagramPacket datagram = new DatagramPacket(sendBuffer, sendBuffer.length, socketMessage.getSenderHostname(), socketMessage.getSenderPort());
        this.send(datagram);
    }

    public SocketMessage receiveMessage() throws IOException {
        byte[] receiveBuffer = new byte[MAX_LEN];
        DatagramPacket datagram = new DatagramPacket(receiveBuffer, MAX_LEN);
        this.receive(datagram);
        return new SocketMessage(new String(receiveBuffer), datagram.getAddress(), datagram.getPort());
    }

}