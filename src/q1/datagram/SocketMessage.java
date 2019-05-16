package q1.datagram;

import java.net.InetAddress;

public class SocketMessage {
    private String message;
    private InetAddress senderHostname;
    private int senderPort;

    public SocketMessage (String message, InetAddress senderHostname, int senderPort) {
        this.message = message;
        this.senderHostname = senderHostname;
        this.senderPort = senderPort;
    }

    private SocketMessage () {}

    public String getMessage() {
        return message;
    }


    public InetAddress getSenderHostname() {
        return senderHostname;
    }

    public int getSenderPort() {
        return senderPort;
    }

}