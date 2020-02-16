package work3;

import java.io.Serializable;

public class School implements Serializable {
	String name;
	public School() {
	// TODO Auto-generated constructor stub
	this.name = "NWAFU";
	}
	@Override
	public String toString() {
		return "schoolName=" + name;
	}
	
}
