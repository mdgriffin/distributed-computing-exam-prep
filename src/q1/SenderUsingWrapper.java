package q1;

import java.net.InetAddress;

public class SenderUsingWrapper {

    private static final int RECEIVER_PORT = 9900;

    public static void main(String[] args) {
        try {
            InetAddress receiverHost = InetAddress.getByName("localhost");
            // Bind to any available port
            DatagramSocketWrapper socketWrapper = new DatagramSocketWrapper();

            socketWrapper.sendMessage(new SocketMessage("Hello From Client", receiverHost, RECEIVER_PORT));

            SocketMessage responseMessage = socketWrapper.receiveMessage();
            System.out.println(responseMessage.getMessage());

            socketWrapper.close( );
        } catch (Exception ex) {
            ex.printStackTrace( );
        }
    }
}
