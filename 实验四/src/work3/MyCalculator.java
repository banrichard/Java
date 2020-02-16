package work3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import java.math.BigDecimal;

public class MyCalculator {

	String str1 = "0";

	String str2 = "0";

	String signal = "+";

	String result = "";

	int k1 = 1;

	int k2 = 1;

	int k3 = 1;

	int k4 = 1;

	int k5 = 1;

	JButton store;

	Vector vt = new Vector(20, 10);

	JFrame frame = new JFrame("Calculator");
	JTextField result_TextField = new JTextField(result, 20);
	JButton buttonClear = new JButton("C");
	JButton button0 = new JButton("0");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton buttonAdd = new JButton("+");
	JButton buttonSub = new JButton("-");
	JButton buttonMul = new JButton("*");
	JButton buttonDiv = new JButton("/");
	JButton buttonEql = new JButton("=");

	// 计算机类的构造器
	public MyCalculator() {

		result_TextField.setHorizontalAlignment(JTextField.RIGHT);
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(4, 4));
		pan.add(button1);
		pan.add(button2);
		pan.add(button3);
		pan.add(buttonAdd);
		pan.add(button4);
		pan.add(button5);
		pan.add(button6);
		pan.add(buttonSub);
		pan.add(button7);
		pan.add(button8);
		pan.add(button9);
		pan.add(buttonMul);
		pan.add(buttonClear);
		pan.add(button0);
		pan.add(buttonEql);
		pan.add(buttonDiv);
		JPanel pan2 = new JPanel();
		pan2.add(result_TextField);

		frame.setLocation(300, 200);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(pan2, BorderLayout.NORTH);
		frame.getContentPane().add(pan, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);

		class Listener implements ActionListener {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				String ss = ((JButton) e.getSource()).getText();
				store = (JButton) e.getSource();
				vt.add(store);
				if (k1 == 1) {
					if (k3 == 1) {
						str1 = "";

						k5 = 1;
					}
					str1 = str1 + ss;

					k3 = k3 + 1;

					result_TextField.setText(str1);

				} else if (k1 == 2) {
					if (k4 == 1) {
						str2 = "";

						k5 = 1;
					}
					str2 = str2 + ss;
					k4 = k4 + 1;
					result_TextField.setText(str2);
				}

			}
		}

		class Listener_signal implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				String ss2 = ((JButton) e.getSource()).getText();
				store = (JButton) e.getSource();
				vt.add(store);

				if (k2 == 1) {

					k1 = 2;
					k5 = 1;
					signal = ss2;
					k2 = k2 + 1;
				} else {
					int a = vt.size();
					JButton c = (JButton) vt.get(a - 2);

					if (!(c.getText().equals("+")) && !(c.getText().equals("-")) && !(c.getText().equals("*"))
							&& !(c.getText().equals("/")))

					{
						cal();
						str1 = result;

						k1 = 2;
						k5 = 1;
						k4 = 1;
						signal = ss2;
					}
					k2 = k2 + 1;

				}

			}
		}

		class Listener_clear implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				store = (JButton) e.getSource();
				vt.add(store);
				k5 = 1;
				k2 = 1;
				k1 = 1;
				k3 = 1;
				k4 = 1;
				str1 = "0";
				str2 = "0";
				signal = "";
				result = "";
				result_TextField.setText(result);
				vt.clear();
			}
		}

		class Listener_dy implements ActionListener {

			public void actionPerformed(ActionEvent e) {

				store = (JButton) e.getSource();
				vt.add(store);
				cal();

				k1 = 1;
				k2 = 1;
				k3 = 1;
				k4 = 1;

				str1 = result;
			}
		}

		class Listener_xiaos implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				store = (JButton) e.getSource();
				vt.add(store);
				if (k5 == 1) {
					String ss2 = ((JButton) e.getSource()).getText();
					if (k1 == 1) {
						if (k3 == 1) {
							str1 = "";

							k5 = 1;
						}
						str1 = str1 + ss2;

						k3 = k3 + 1;

						result_TextField.setText(str1);

					} else if (k1 == 2) {
						if (k4 == 1) {
							str2 = "";

							k5 = 1;
						}
						str2 = str2 + ss2;

						k4 = k4 + 1;

						result_TextField.setText(str2);
					}
				}

				k5 = k5 + 1;
			}
		}

		Listener_dy jt_dy = new Listener_dy();

		Listener jt = new Listener();

		Listener_signal jt_signal = new Listener_signal();

		Listener_clear jt_c = new Listener_clear();

		Listener_xiaos jt_xs = new Listener_xiaos();

		button7.addActionListener(jt);
		button8.addActionListener(jt);
		button9.addActionListener(jt);
		buttonDiv.addActionListener(jt_signal);
		button4.addActionListener(jt);
		button5.addActionListener(jt);
		button6.addActionListener(jt);
		buttonMul.addActionListener(jt_signal);
		button1.addActionListener(jt);
		button2.addActionListener(jt);
		button3.addActionListener(jt);
		buttonSub.addActionListener(jt_signal);
		button0.addActionListener(jt);
		buttonEql.addActionListener(jt_dy);
		buttonAdd.addActionListener(jt_signal);
		buttonClear.addActionListener(jt_c);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void cal() {

		double a2;

		double b2;

		String c = signal;

		double result2 = 0;

		if (c.equals("")) {
			result_TextField.setText("Please input operator");

		} else {

			if (str1.equals("."))
				str1 = "0.0";
			if (str2.equals("."))
				str2 = "0.0";
			a2 = Double.valueOf(str1).doubleValue();
			b2 = Double.valueOf(str2).doubleValue();

			if (c.equals("+")) {
				result2 = a2 + b2;
			}
			if (c.equals("-")) {
				result2 = a2 - b2;
			}
			if (c.equals("*")) {
				BigDecimal m1 = new BigDecimal(Double.toString(a2));
				BigDecimal m2 = new BigDecimal(Double.toString(b2));
				result2 = m1.multiply(m2).doubleValue();
			}
			if (c.equals("/")) {
				if (b2 == 0) {
					result2 = 0;
				} else {
					result2 = a2 / b2;
				}

			}

			result = ((new Double(result2)).toString());

			result_TextField.setText(result);
		}
	}

	public static void main(String[] args) {
		MyCalculator cal = new MyCalculator();
	}

}