package jdbc.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo2 {
	private static final String url = "jdbc:mysql://localhost:3306/computer";
	private static final String user = "root";
	private static final String password = "root";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("main method start ");

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("connection created...!!!");

		Statement stmt = conn.createStatement();
		
		String update_query=" update computer set price=20000 where ic_no=110;";
		int rows=stmt.executeUpdate(update_query);
		System.out.println("Rows updtaed "+rows);
		System.out.println(conn.getClass().getName());
		System.out.println(stmt.getClass().getName());
		ResultSet rs = stmt.executeQuery(" select *from computer;");
		while (rs.next()) {
			int IMEI_NO = rs.getInt("IC_NO");
			String company = rs.getString("company_name");
			int model_name = rs.getInt("RAM");
			int Processor = rs.getInt("ROM");
			String country = rs.getString("versions"); 
			System.out.println("IMEI_NO "+IMEI_NO+ "\tcompany:     "+company);
	 }
}}