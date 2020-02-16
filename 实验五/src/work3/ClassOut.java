package work3;

import java.io.*;
import java.util.*;

public class ClassOut {
	public ClassOut() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Student lee = new Student(1001, "Lee", 21);
		Student zhang = new Student(1003, "Zhang", 22);
		File student = new File(".\\files", "student.txt");

		try {
			FileOutputStream outFile = new FileOutputStream(student);
			ObjectOutputStream objectOut = new ObjectOutputStream(outFile);
			objectOut.writeObject(lee);
			objectOut.flush();
			objectOut.writeObject(zhang);
			objectOut.flush();
			objectOut.close();
			outFile.close();
			FileInputStream inFile = new FileInputStream(student);
			ObjectInputStream studentIn = new ObjectInputStream(inFile);
			Student zhao = (Student)studentIn.readObject();
			zhao.setName("Zhao");
			System.out.println("这是zhao深拷贝并执行修改姓名方法的结果："+zhao.toString());//深拷贝
			System.out.println("这是lee经过zhao深拷贝结果:"+lee.toString());
			Student wang = lee;
			System.out.println("这是wang浅拷贝结果:"+wang.toString());
			wang.setName("Wang");
			System.out.println("这是lee经过wang浅拷贝执行修改姓名方法后的结果："+lee.toString());
//			Object obj = null;
//			try {
//				while ((obj = studentIn.readObject()) != null) {
//					if (obj instanceof Student) {
//						System.out.println(((Student) obj).toString());
//					}
//				}
//			} catch (EOFException e) {
//			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
