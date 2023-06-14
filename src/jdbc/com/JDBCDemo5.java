package jdbc.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo5 {
	private static final String url = "jdbc:mysql://localhost:3306/Mahindra";
	private static final String user = "root";
	private static final String password = "root";

	public static void main(String[] args) throws IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection(url, user, password);

			Statement stmt = conn.createStatement();

			
			String Update_Query = " insert into cars_details(sr_no,car_name,car_type,car_price) values(?, ?, ? ,?)";
//			String Update_Query1 = "delete from _cars_details where sr_no=51;";
//			
//			int row=stmt.executeUpdate(Update_Query1);
//			System.out.println("executeUpdate sucessfully "+row);
//			
			
			
			PreparedStatement pstmt=conn.prepareStatement(Update_Query);
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter sr_no");
			int sr_no=Integer.parseInt(br.readLine());
			
			System.out.println("Enter car name\n");
			String car_name=br.readLine();
			
			System.out.println("Enter car Type\n");
			String car_type=br.readLine();
			
			System.out.println("Enter car price\n");
			int price=Integer.parseInt(br.readLine());
			
			pstmt.setInt(1, sr_no);
			pstmt.setString(2, car_name);
			pstmt.setString(3,car_type);
			pstmt.setInt(4,price);
			pstmt.executeUpdate();
			System.out.println("Inserted.....");
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
