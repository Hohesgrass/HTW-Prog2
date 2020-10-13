package server;

import java.io.IOException;

public class main {
    public static void main(String[] Args) throws IOException, InterruptedException {
        TCPServer tcp = new TCPServer();
        tcp.run();
    }
}
