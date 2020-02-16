package work1;
import java.awt.*;

import javax.swing.*;


public class Windowmouse extends JFrame{
	JButton button1,button2;
	JTextArea topArea,bottomArea;
	MousePolice police;
	Mousecancel cancel;
	Windowmouse(){
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init() {
		police = new MousePolice();
		cancel = new Mousecancel();
		setLayout(new BorderLayout());
		button1 = new JButton("发送");
		button1.addMouseListener(police);
		button2 = new JButton("清除");
		button2.addMouseListener(cancel);
		topArea = new JTextArea(200,50);
		bottomArea = new JTextArea(200,50);
		JScrollPane topScroll = new JScrollPane(topArea);
		topScroll.setSize(200, 50);
		JScrollPane bottomScroll = new JScrollPane(bottomArea);
		bottomScroll.setSize(200, 50);
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,topScroll,bottomScroll);
		split.setLeftComponent(topScroll);
		split.setBottomComponent(bottomScroll);
		split.setDividerLocation(200);
		setBounds(500,500,500,500);
		add(split,BorderLayout.CENTER);
		JPanel bottomButton = new JPanel();
		bottomButton.add(button1);
		bottomButton.add(button2);
		add(bottomButton,BorderLayout.SOUTH);
		police.setInput(bottomArea);
		police.setOutput(topArea);
		cancel.setInput(bottomArea);
		cancel.setOutput(topArea);
		}
}
