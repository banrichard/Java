package work2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Gui extends JFrame {
	JLabel num;
	JLabel name;
	JLabel price;
	JLabel date;
	JButton select;
	JButton clear;
	JTextField inNum;
	JTextField outName;
	JTextField outPrice;
	JTextField outDate;
	Box boxH;
	Box boxVOne, boxVTwo;

	public Gui() {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void init() {
		setLayout(new FlowLayout());
		boxH = Box.createHorizontalBox();
		boxVOne = Box.createVerticalBox();
		boxVTwo = Box.createVerticalBox();
		num = new JLabel("商品编号:");
		boxVOne.add(num);
		inNum = new JTextField(20);
		boxVTwo.add(inNum);
		select = new JButton("查询");
		select.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Query tem = new Query();
				String[] needRes = tem.getData(inNum.getText());
				outName.setText(needRes[0]);
				outPrice.setText(needRes[1]);
				outDate.setText(needRes[2]);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		clear = new JButton("清除界面字符");
		clear.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				inNum.setText("");
				outName.setText("");
				outPrice.setText("");
				outDate.setText("");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		name = new JLabel("商品名称:");
		boxVOne.add(name);
		outName = new JTextField(20);
		outName.setEditable(false);
		boxVTwo.add(outName);
		price = new JLabel("商品价格:");
		boxVOne.add(price);
		outPrice = new JTextField(20);
		outPrice.setEditable(false);
		boxVTwo.add(outPrice);
		date = new JLabel("生产日期:");
		boxVOne.add(date);
		outDate = new JTextField(20);
		outDate.setEditable(false);
		boxVTwo.add(outDate);
		boxH.add(boxVOne);
		boxH.add(boxVTwo);
		add(boxH);
		add(select);
		add(clear);
	}

}
