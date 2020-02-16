package work2;

import java.sql.*;

public class Query {
	public String [] getData(String s) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
		String []res = new String[3];
		Connection con;
		String url = "jdbc:mysql://localhost/test?useSSL=true";
		String user = "root";
		String password = "";
		Statement sql;
		ResultSet rs;
		String productId;
		try {
			productId = s;
			con = DriverManager.getConnection(url, user, password);
			sql = con.createStatement();
			rs = sql.executeQuery("Select * from product where ProductID ="+productId);
			while (rs.next()) {
				res[0] = rs.getString(2);
				res[1] = rs.getString(3);
				res[2] = rs.getString(4);
			}
			con.close();
		} catch (Exception e) {
		}
		return res;
	}
}
