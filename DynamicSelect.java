package com.tyss.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DynamicSelect {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
	String query="select * from employee where id=?";
	
	pstmt=con.prepareStatement(query);
	pstmt.setInt(1, 30);
	rs=pstmt.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getInt("id"));
		System.out.println(rs.getString("name"));
		System.out.println(rs.getInt("sal"));
		System.out.println(rs.getInt("phone"));
	}
		}
	catch(Exception e) {
		e.printStackTrace();
	
	}

	}

}
