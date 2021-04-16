package com.tyss.jdbc.driver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticUpdate {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
		try {
			//1.
			Driver d=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			//2.
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			
			//3.
			String query="update employee set phone=78987658 where id=20";
			stmt=con.createStatement();
			//4.
			int count=stmt.executeUpdate(query);
			System.out.println("number of affect:"+count);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
