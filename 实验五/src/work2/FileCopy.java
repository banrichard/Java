package work2;

import java.io.*;
import java.util.*;

public class FileCopy {

	public FileCopy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("请输入文件路径:");
			String fileRoot = in.next();
			System.out.println("请输入文件名称:");
			String fileName = in.next();
			char[] c = new char[200];
			File toCopy = new File(fileRoot + "\\" + fileName);
			File destination = new File(".\\filescopy", fileName);
			FileReader inFile = new FileReader(toCopy);
			FileWriter out = new FileWriter(destination);
			int n = -1;
			while ((n = inFile.read(c)) != -1) {
				out.write(c, 0, n);
			}
			out.flush();
			out.close();
			inFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
