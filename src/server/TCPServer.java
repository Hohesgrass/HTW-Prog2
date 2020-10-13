package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public void run() throws IOException, InterruptedException {
        int port = 3333;
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();

        byte[] readBuffer = new byte[1600];
        try {
            is.read(readBuffer);
        } catch (IOException ex) {
            System.err.println("couldn’t read data (fatal)");
            System.exit(0);
        }
        String readString = new String(readBuffer);
        System.out.println(readString);
        OutputStream os = socket.getOutputStream();
        os.write("Hallo".getBytes());

        Thread.sleep(5000);
        os.close();

    }
}
