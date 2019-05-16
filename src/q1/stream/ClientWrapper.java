package q1.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.Buffer;

public class ClientWrapper {

    private InetAddress serverAddress;
    private int serverPort;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientWrapper (InetAddress serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;

        try {
            openConnection();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void openConnection() throws IOException {
        socket = new Socket(serverAddress, serverPort);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void send(String msg) {
        out.println(msg);
    }

    public String receive () throws IOException {
        return in.readLine();
    }

}
