package q1.stream;

import java.net.InetAddress;

public class ClientUsingWrapper {

    public static void main(String[] args) {
        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int portNum = 9000;

            ClientWrapper clientWrapper = new ClientWrapper(serverAddress, portNum);
            clientWrapper.send("Hello From Client");

            String serverResponse = clientWrapper.receive();
            System.out.println(serverResponse);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}
