package q1.stream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {


    public static void main(String[] args) {
        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            // Address of server and server port num
            Socket clientSocket = new Socket(serverAddress, 9000);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            out.println("Hello From Client");

            String serverResponse = in.readLine();
            System.out.println(serverResponse);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
