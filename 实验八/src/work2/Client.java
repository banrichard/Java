package work2;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = new Socket();
		InetSocketAddress isa = new InetSocketAddress("localhost", 2018);
		DataInputStream in = null;
		DataOutputStream out = null;
		Scanner reader = new Scanner(System.in);
		try {
			socket.connect(isa);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			System.out.println("请输入文件名:");
			String s = reader.next();
			out.writeUTF(s);
			byte[] b = new byte[100000];
			FileOutputStream outStream = new FileOutputStream("destination\\" + s);
			while (in.read(b) != -1) {
				outStream.write(b);
				outStream.flush();
			}
			outStream.close();
			out.close();
			System.out.println("文件传输完成!");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件传输失败！");
		}
	}

}
