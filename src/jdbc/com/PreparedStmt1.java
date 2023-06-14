package jdbc.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStmt1 {
	private static final String url = "jdbc:mysql://localhost:3306/computer";
	private static final String user = "root";
	private static final String password = "root";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, password);
		String fecth_query = " select ic_no,company_name,price from computer where ram>?;";
		PreparedStatement stm = conn.prepareStatement(fecth_query);
		Statement pstmt = conn.createStatement();

		stm.setInt(1, 5);// first 1 is value of ? is 5 on 1 means that no
		ResultSet rs = stm.executeQuery();
		System.out.println("ic_no   " + "company_name   " + " price");
		System.out.println(conn.getClass().getName());
		System.out.println(stm.getClass().getName());
		System.out.println(pstmt.getClass().getName() + "\n");

		while (rs.next()) {
			int ic_no = rs.getInt("ic_no");
			String company_name = rs.getString("company_name");
			int price = rs.getInt("price");
			System.out.println(ic_no + "       " + company_name + "             " + price);
		}

	}
}