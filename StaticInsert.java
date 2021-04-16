package com.tyss.jdbc.driver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticInsert {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
	//	1.Load the Driver
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
		//	Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Driver	d = new com.mysql.jdbc.Driver();
     		Driver d=new com.mysql.cj.jdbc.Driver();
	     	DriverManager.registerDriver(d);
			System.out.println("driver loaded successfully.....");
			
			//2.get connection via driver
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			
			//3.Issue SQL Query via connection
			String query="insert into employee values(40,'Aishwarya',44500,'technical',935218905)";
			stmt=con.createStatement();
			
			 // 4.Process the resultset
			int count=stmt.executeUpdate(query);
			System.out.println("number of rows affected:" +count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5.close all JDBC objects
	finally {
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	}

}
