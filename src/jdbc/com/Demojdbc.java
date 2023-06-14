package jdbc.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demojdbc {

	private static final String url = "jdbc:mysql://localhost:3306/cars";
	private static final String user = "root";
	private static final String password = "root";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("main method start ");

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("connection created...!!!");

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select *from cars");
		while (rs.next()) {
			int Rto_no = rs.getInt("Rto_no");
			String car_name = rs.getString("car_name");
			String company_name = rs.getString("company_name");
			int price = rs.getInt("price");
			String country = rs.getString("country");
			System.out.println("Rto no " + Rto_no + "\tcar_name:     " + price + "\tcountry:     " + car_name
					+ "\t\t\tprice:     " + country);
		}

	}
}
