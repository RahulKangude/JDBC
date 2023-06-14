package jdbc.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Utilclass {
	private static final String url = "jdbc:mysql://localhost:3306/computer";
	private static final String user = "root";
	private static final String password = "root";

	static Connection getJDBCconnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
}

public class JdbcDemo3 {

	public static void main(String[] args) {
		System.out.println("---------welcome to JDBC code");
		String fetch_equery = "select *from computer";

		try (Connection conn = Utilclass.getJDBCconnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(fetch_equery);) {
			Class.forName("com.mysql.cj.jdbc.Driver");

			while (rs.next()) {
				int IMEI_NO = rs.getInt("IC_NO");
				String company = rs.getString("company_name");
	 			int model_name = rs.getInt("RAM");
				int Processor = rs.getInt("ROM");
				String country = rs.getString("versions");
				System.out.println("IMEI_NO " + IMEI_NO + "\tcompany:     " + company);
			}

		} catch (SQLException e) {
			System.out.println("check your user,password");
			throw new RuntimeException();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("check your jar file");
		}
		/*
		 * finally { if (stmt != null) { try { stmt.close(); } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); } } if (conn != null) { try { conn.close(); } catch
		 * (SQLException e) {
		 * 
		 * e.printStackTrace(); } } if (rs != null) { try { rs.close(); } catch
		 * (SQLException e) {
		 * 
		 * e.printStackTrace(); } }
		 */
		System.out.println("---------End to JDBC code");
	}
}
