package work3;

import java.io.Serializable;

public class Student implements Serializable {
	private int id; // 学号
	private String name; // 姓名
	private int age; // 年龄
	private School school;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.school = new School();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", " + school.toString() + "]";
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

	public String getSchool() {
		return this.school.toString();
	}
}
