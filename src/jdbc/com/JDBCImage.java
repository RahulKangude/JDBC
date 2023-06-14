package jdbc.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCImage {
	private static final String url = "jdbc:mysql://localhost:3306/mahindra";
	private static final String user = "root";
	private static final String password = "root";
	
  public static void main(String[] args) throws IOException {
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection	conn = DriverManager.getConnection(url, user, password);
	String q="insert into image(id,pic) values(?,?)";
	PreparedStatement pstmt=conn.prepareStatement(q); 
	pstmt.setInt(1, 1);
	FileInputStream fis=new FileInputStream("D:\\Eclips\\javaprogram\\JDBC\\src\\Mypic.jpg");
	pstmt.setBinaryStream(2, fis,fis.available());
	
	pstmt.executeUpdate();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  
}
}
