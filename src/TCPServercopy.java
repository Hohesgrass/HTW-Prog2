import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServercopy {

    public void run() throws IOException, InterruptedException {
        int port = 3333;
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();

        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        try {
            String read = dis.readUTF();
            System.out.println("read: " + read);
        } catch (IOException ex) {
            System.err.println("couldn’t read data (fatal)");
            System.exit(0);
        }

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        try {
            dos.writeUTF("Hello World");

        } catch (IOException ex) {
            System.err.println("couldn’t write data (fatal)");
            System.exit(0);
        }
        Thread.sleep(5000);
        os.close();

    }
}
