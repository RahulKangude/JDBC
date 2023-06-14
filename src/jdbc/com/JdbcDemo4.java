package jdbc.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo4 {
	public static void main(String[] args) {
		System.out.println("******************Start of JDBC code**************");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = Demo4.getConnection();
			Statement stmt = conn.createStatement();
//			String Update_qurey = "update cars set price=22222 where rto_no=2222";
//			int row = stmt.executeUpdate(Update_qurey);
//			System.out.println("rows updated" + row);	

			String fetch_query = "select *from cars";
			ResultSet rs = stmt.executeQuery(fetch_query);
			System.err.println("Rto_no "        +"                 \tcar_name:     \n" );
			while(rs.next()) {
				
			int Rto_no = rs.getInt("Rto_no");
			String car_name = rs.getString("car_name");
			String company_name = rs.getString("company_name");
			int price = rs.getInt("price");
			String country = rs.getString("country");
			System.out.println("Rto_no " + Rto_no + "\tcar_name:     " + car_name);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Check your jar file");
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("\n******************End of JDBC code*****************");
	}
}

class Demo4 {
	private static final String url = "jdbc:mysql://localhost:3306/cars";
	private static final String user = "root";
	private static final String password = "root";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;
	}

}