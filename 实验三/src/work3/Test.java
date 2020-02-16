package work3;
import java.util.*;
class StudentKey implements Comparable{
	int number;
	StudentKey(int n){
		this.number = n;
	}
	@Override
	public int compareTo(Object o) {
		StudentKey s = (StudentKey) o;
		return (this.number -s.number);
	}
	
}
class Student{
	String name;
	String homeTown;
	int stuNo;
	Student(String n,String h,int no){
		this.name = n;
		this.homeTown = h;
		this.stuNo = no;
	}
}
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<StudentKey,Student> treemap = new TreeMap<StudentKey,Student>();
		String []name = {"赵一","钱二","张三","李四","王五"};
		String []city = {"上海","北京","广州","深圳","青岛"};
		int []no= {20180001,2018002,2018003,2018004,2018005};
		Student student[] = new Student[5];
		for(int k=0;k<student.length;k++) {
			student[k] = new Student(name[k],city[k],no[k]);
		}
		StudentKey key[] = new StudentKey[5];
		for(int k=0; k<key.length;k++) {
			key[k] = new StudentKey(student[k].stuNo);
		}
		for(int k=0; k<student.length;k++) {
			treemap.put(key[k], student[k]);
		}
		Collection<Student> collection = treemap.values();
		Iterator<Student> iter = collection.iterator();
		while(iter.hasNext()) {
			Student stu = iter.next();
			System.out.println("姓名："+stu.name+" "+"学号："+stu.stuNo+"籍贯："+stu.homeTown);
		}
		Student selected = treemap.get(key[0]);
		System.out.println(selected.homeTown);
		iter = collection.iterator();
		String home = "北京";
		while(iter.hasNext()) {
			Student stu = iter.next();
			if(stu.homeTown==home)
				System.out.println("姓名："+stu.name+" "+"学号："+stu.stuNo+"籍贯："+stu.homeTown);
		}
		
	}

}
