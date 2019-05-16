package q1.stream;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        if (args.length != 2)
            System.out.println("This program requires two command line arguments");
        else {
            try {
                int portNo = Integer.parseInt(args[0]);
                String message = args[1];

                ServerSocket connectionSocket = new ServerSocket(portNo);

                Socket dataSocket = connectionSocket.accept();
                OutputStream outStream = dataSocket.getOutputStream();
                PrintWriter socketOutput = new PrintWriter(new OutputStreamWriter(outStream));
                socketOutput.println(message);

                socketOutput.flush();
                dataSocket.close();
                connectionSocket.close();
            } // end try
            catch (Exception ex) {
                ex.printStackTrace();
            } //end catch
        } // end else
    } // end main
} // end class
