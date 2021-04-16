package com.tyss.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicInsert {

	public static void main(String[] args) {
		try {
		Connection con=null;
		PreparedStatement pstmt=null;
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		 String query="insert into employee values(?,?,?,?,?)";
		 pstmt=con.prepareStatement(query);
		 pstmt.setInt(1,50);
		 pstmt.setString(2,"kavya");
		 pstmt.setInt(3,27000 );
		 pstmt.setString(4,"System" );
		 pstmt.setInt(5,87564334 );
		 System.out.println("inserted...");
		 pstmt.executeUpdate();
	}
		 
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
