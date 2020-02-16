package work1;

import java.io.*;
import java.util.*;

public class FileMerge {
	public FileMerge() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			File file = new File(".\\files\\poem");
			File[] fileList = file.listFiles();
			FileReader in1 = new FileReader(fileList[0]);
			FileReader in2 = new FileReader(fileList[1]);
			File newPoem = new File(".\\files", "李白诗集.txt");
			FileWriter toFile = new FileWriter(newPoem);
			BufferedReader inOne = new BufferedReader(in1);
			BufferedReader inTwo = new BufferedReader(in2);
			BufferedWriter out = new BufferedWriter(toFile);
			String str = null;
			while ((str = inOne.readLine()) != null) {
				out.write(str);
				out.newLine();
				out.flush();
			}
			while ((str = inTwo.readLine()) != null) {
				out.write(str);
				out.newLine();
				out.flush();
			}
			out.close();
			toFile.close();
			inOne.close();
			inTwo.close();
			in1.close();
			in2.close();
		} catch (IOException e) {
		}
	}

}
