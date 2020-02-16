package work3;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client extends JFrame {
	JButton con;
	JPanel textFieldArea;
	JSplitPane split;
	JLabel sideA;
	JLabel sideB;
	JLabel sideC;
	JTextField a;
	JTextField b;
	JTextField c;
	JButton send;
	JTextArea res;
	Socket socket = new Socket();
	InetSocketAddress isa = new InetSocketAddress("localhost", 2018);
	DataInputStream in = null;
	DataOutputStream out = null;
	ObjectOutputStream outObj = null;
	public Client() {
		// TODO Auto-generated constructor stub
		init();
		setVisible(true);
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("客户端");
	}

	public void init() {
		setLayout(new BorderLayout());
		con = new JButton("连接到服务器");
		con.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					socket.connect(isa);
					Client.this.res.setText("连接服务器成功，当前端口地址：" + Client.this.socket.getLocalSocketAddress()+"\n");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("连接失败！");
				}
			}
		});
		sideA = new JLabel("sideA");
		sideB = new JLabel("sideB");
		sideC = new JLabel("sideC");
		a = new JTextField(10);
		b = new JTextField(10);
		c = new JTextField(10);
		send = new JButton("send");
		send.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					double valA = Double.valueOf(a.getText());
					double valB = Double.valueOf(b.getText());
					double valC = Double.valueOf(c.getText());
					Triangle sendTri = new Triangle(valA, valB, valC);
					in = new DataInputStream(socket.getInputStream());
					out = new DataOutputStream(socket.getOutputStream());
					outObj = new ObjectOutputStream(out);
					if (sendTri.isLegal()) {
						outObj.writeObject(sendTri);
						Client.this.res.append("服务器返回结果：" + in.readUTF()+"\n");
					}
					else {
						Client.this.res.append("构不成三角形");
					}
					outObj.close();
					out.close();
					in.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					System.out.println("发送失败！");
				}
			}
		});
		res = new JTextArea();
		textFieldArea = new JPanel();
		textFieldArea.add(sideA);
		textFieldArea.add(a);
		textFieldArea.add(sideB);
		textFieldArea.add(b);
		textFieldArea.add(sideC);
		textFieldArea.add(c);
		textFieldArea.add(send);
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, con, textFieldArea);
		split.setDividerSize(0);
		add(split, BorderLayout.NORTH);
		add(res, BorderLayout.CENTER);
	}
}
