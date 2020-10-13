import java.io.*;

public class main {
    public static void main(String[] Args){
       writeInFile("lololol", "hallo.txt");
       readFile("hallo.txt");
    }



    public static void writeInFile(String text, String filen) {
        OutputStream os = null;
        try{
            String filename = filen;
            os = new FileOutputStream(filename);
        } catch(FileNotFoundException ex){
            System.err.println("couldn't open file - fatal");
            System.exit(0); // brutal
        }
        DataOutputStream dos = new DataOutputStream(os);
        try {
            dos.writeUTF(text);
            System.out.println(text);

        } catch (IOException ex) {
            System.err.println("couldn’t write data (fatal)");
            System.exit(0);
        }

    }
    public static void readFile(String filename){
        InputStream is = null;
        try {
            is = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0);
        }
        DataInputStream dis = new DataInputStream(is);
        try {
            String readIntValue = dis.readUTF();
            System.out.println("read integer: " + readIntValue);
        } catch (IOException ex) {
            System.err.println("couldn’t read data (fatal)");
            System.exit(0);
        }

    }
}
