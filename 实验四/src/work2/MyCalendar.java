package work2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

public class MyCalendar extends JFrame implements ActionListener {
	JPanel pCenter;
	JPanel pNorth;
	JPanel pSouth;
	JPanel rili;
	JButton previousMonth;
	JButton nextMonth;
	JLabel[] label = new JLabel[42];
	JTextArea area;
	Calendar now = Calendar.getInstance();
	CalendarBean cb = new CalendarBean();
	String[] a;
	JPanel dayPanel;
	int year = now.get(Calendar.YEAR);
	int month = now.get(Calendar.MONTH) + 1;;

	MyCalendar() {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void init() {
		setLayout(new BorderLayout());
		setBounds(500, 500, 500, 500);
		pCenter = new JPanel(new GridLayout(6, 7));
		dayPanel = new JPanel(new GridLayout(1, 7));
		rili = new JPanel(new BorderLayout());
		pNorth = new JPanel(new FlowLayout());
		pSouth = new JPanel(new FlowLayout());
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		previousMonth = new JButton("上月");
		previousMonth.addActionListener(this);
		nextMonth = new JButton("下月");
		nextMonth.addActionListener(this);
		pNorth.add(previousMonth);
		pNorth.add(nextMonth);
		area = new JTextArea();
		area.setText("日历:" + year + "年" + month + "月");
		pSouth.add(area);
		String[] dayNumber = { "日", "一", "二", "三", "四", "五", "六" };
		JButton[] day = new JButton[7];
		for (int i = 0; i < day.length; i++) {
			day[i] = new JButton(dayNumber[i]);
			dayPanel.add(day[i]);
		}
		cb.setYear(2019);
		cb.setMonth(11);
		a = cb.getCalendar();
		for (int i = 0; i < a.length; i++) {
			label[i] = new JLabel("       " + a[i]);
			pCenter.add(label[i]);
		}
		for (int i = a.length; i < 42; i++) {
			label[i] = new JLabel("");
			pCenter.add(label[i]);
		}
		rili.add(dayPanel, BorderLayout.NORTH);
		rili.add(pCenter, BorderLayout.CENTER);
		add(rili, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == previousMonth) {
			month = month - 1;
			if (month < 1) {
				month = 12;
				cb.setYear(year - 1);
			}
			cb.setMonth(month);
			String day[] = new String[42];
			day = cb.getCalendar();
			for (int i = 0; i < 42; i++) {
				label[i].setText("       " + day[i]);
			}
			area.setText("日历:" + year + "年" + month + "月");
		} else if (e.getSource() == nextMonth) {
			month = month + 1;
			if (month > 12) {
				month = 1;
				cb.setYear(year + 1);
			}
			cb.setMonth(month);
			String day[] = new String[42];
			day = cb.getCalendar();
			for (int i = 0; i < 42; i++) {
				label[i].setText("       " + day[i]);
			}
			area.setText("日历:" + year + "年" + month + "月");
		}
	}

}
