package com.tyss.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DynamicUpdate {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		String query="update employee set name=? where id=?";
		
		pstmt=con.prepareStatement(query);
		//binding the parameter
		
		pstmt.setString(1, "bhavani");//1 means first question mark in query
		pstmt.setInt(2, 30);//2 MEANS second question mark
		
		int count=pstmt.executeUpdate();
		System.out.println("updated......");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		finally {
			try {
			if(con!=null)
				con.close();
			if(pstmt!=null)
				pstmt.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
