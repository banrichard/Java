package work3;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket sSocket = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        ObjectInputStream inObj = null;
        try {
            sSocket = new ServerSocket(2018);
            socket = sSocket.accept();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            inObj = new ObjectInputStream(in);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        try {
            Triangle tri = (Triangle) inObj.readObject();
            out.writeUTF(tri.calculateArea());
            out.close();
            inObj.close();
            in.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

