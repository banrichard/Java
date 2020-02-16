package work1;
import java.io.IOException;
import java.net.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = new Socket();//c1
		InetSocketAddress isa = new InetSocketAddress("localhost", 2018);
		try {
			socket.connect(isa);//c2
			System.out.println(socket.getInetAddress());//c3
			System.out.println(socket.getPort());//c4
			System.out.println(socket.getLocalSocketAddress());//c5
			System.out.println(socket.getLocalPort());//c6
			socket.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("连接失败！");
		}
	}

}
