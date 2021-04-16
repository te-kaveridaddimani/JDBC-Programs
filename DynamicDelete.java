package com.tyss.dynamic;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicDelete {

	public static void main(String[] args) {
		try {
		Connection con=null;
		PreparedStatement pstmt=null;
		Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		
	String query="delete from employee where id=?";
		
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1,30);
		System.out.println("deleted....");
		pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
