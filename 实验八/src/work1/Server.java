package work1;

import java.io.IOException;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		ServerSocket sSocket = null;
		Socket socket = null;
		try {
			sSocket = new ServerSocket(2018);//s1
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("端口被占用!");
		}
		try {
			socket = sSocket.accept();//s2
			System.out.println(socket.getInetAddress());//s3
			System.out.println(socket.getPort());//s4
			System.out.println(socket.getLocalSocketAddress());//s5
			System.out.println(socket.getLocalPort());//s6
			socket.close();
		} catch (IOException e) {
			System.out.println("客户端连接异常");
		}
	}
}
