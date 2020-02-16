package work4;

import java.util.*;
import java.net.*;

public class UDPB implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Thread readData;
		UDPB receiver = new UDPB();
		try {
			readData = new Thread(receiver);
			readData.start();
			byte[] buffer = new byte[1];
			InetAddress address = InetAddress.getByName("localhost");
			DatagramPacket dataPack = new DatagramPacket(buffer, buffer.length, address, 888);
			DatagramSocket postMan = new DatagramSocket();
			System.out.print("发给UDPA的信息：");
			while (scanner.hasNext()) {
				String mes = scanner.nextLine();
				buffer = mes.getBytes();
				if (mes.length() == 0) {
					System.exit(0);
				}
				buffer = mes.getBytes();
				dataPack.setData(buffer);
				postMan.send(dataPack);
				System.out.print("继续输入发送给UDPA的消息：");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DatagramPacket pack = null;
		DatagramSocket postMan = null;
		byte[] data = new byte[8192];
		try {
			pack = new DatagramPacket(data, data.length);
			postMan = new DatagramSocket(888);
		} catch (Exception e) {
			// TODO: handle exception
		}
		while (true) {
			if (postMan == null) {
				break;
			} else {
				try {
					postMan.receive(pack);
					String message = new String(pack.getData(), 0, pack.getLength());
					System.out.printf("%25s\n", "收到：" + message);
					if (message.equals("TIME")) {
						String mes = new Date().toGMTString();
						byte[] buffer = new byte[1];
						InetAddress address = InetAddress.getByName("localhost");
						DatagramPacket dataPack = new DatagramPacket(buffer, buffer.length, address, 888);
						DatagramSocket postMan1 = new DatagramSocket();
						buffer = mes.getBytes();
						if (mes.length() == 0) {
							System.exit(0);
						}
						buffer = mes.getBytes();
						dataPack.setData(buffer);
						postMan1.send(dataPack);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
}
