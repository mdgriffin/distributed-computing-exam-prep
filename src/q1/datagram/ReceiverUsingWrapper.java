package q1.datagram;

public class ReceiverUsingWrapper {

    private static final int PORT_NUM = 9900;

    public static void main(String[] args) {
        try {
            DatagramSocketWrapper socketWrapper = new DatagramSocketWrapper(PORT_NUM);

            SocketMessage clientMessage = socketWrapper.receiveMessage();
            System.out.println(clientMessage.getMessage());

            socketWrapper.sendMessage(new SocketMessage("Hello From Server", clientMessage.getSenderHostname(), clientMessage.getSenderPort()));

            socketWrapper.close();
        } catch (Exception ex) {
            ex.printStackTrace( );
        }
    }
}
