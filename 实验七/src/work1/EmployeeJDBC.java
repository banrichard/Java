package work1;

import java.sql.*;

public class EmployeeJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
		Connection con;
		String url = "jdbc:mysql://localhost/test?useSSL=true";
		String user = "root";
		String password = "";
		Statement sql;
		ResultSet rs;
		String records = "(1002,'Tom','male',2600)," + 
						"(1003,'Mary','female',3200)," + 
						"(1004,'Peter','male',3000),"+ 
						"(1005,'John','male',7000)," + 
						"(1006,'Paul','male',4000)";
		String sqlStrInsert = "insert into employee values" + records;
		String sqlStrAddSalary = "update employee set salary = salary+1500";
		String sqlStrSelect = "Select name,salary from employee where sex = 'male' and salary = (select MAX(salary) from employee)";
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("连接成功");
			sql = con.createStatement();
			rs = sql.executeQuery(sqlStrSelect);
//			int ok = sql.executeUpdate(sqlStrAddSalary);
			while (rs.next()) {
//				int id = rs.getInt(1);
				String name = rs.getString(1);
//				String sex = rs.getString(3);
				int salary = rs.getInt(2);
//				System.out.printf("%d\t",id);
				System.out.printf("%s\t",name);
//				System.out.printf("%s\t",sex);
				System.out.printf("%d\t",salary);
				System.out.println();
			}
//			int ok = sql.executeUpdate(sqlStrAddSalary);将表中数据读出，每人加1500工资
//			while(rs.next()) { 
//				int id = rs.getInt(1);
//				String name = rs.getString(2);
//				String sex = rs.getString(3);
//				int salary = rs.getInt(4);
//				System.out.printf("%d\t",id);
//				System.out.printf("%s\t",name);
//				System.out.printf("%s\t",sex);
//				System.out.printf("%d\t",salary);
//				System.out.println();
//			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
	}

}
