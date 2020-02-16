package work2;

import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket sSocket = null;
		Socket socket = null;
		DataOutputStream out = null;
		DataInputStream in =null;
		FileInputStream inStream =null;
		try {
			sSocket = new ServerSocket(2018);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接服务器异常!");
		}
		try {
			System.out.println("Waiting for calling...");
			socket = sSocket.accept();
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			String s = "source\\"+in.readUTF();
			inStream = new FileInputStream(s);
			byte []b = new byte[100000];
			System.out.println("正在读取文件:"+s);
			while((inStream.read(b))!=-1) {
				out.write(b);
				out.flush();
			}
			out.close();
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println("读取文件失败");
			}
	}

}
