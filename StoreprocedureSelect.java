package com.tyss.jdbc.driver;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class StoreprocedureSelect {

	public static void main(String[] args) {
		Connection con=null;
		CallableStatement ca=null;
		ResultSet rs=null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
         String query="{call dis_employee()}";
         ca=con.prepareCall(query);
         rs=ca.executeQuery();
         while(rs.next()) {
        	 System.out.println(rs.getInt("id"));
        	 System.out.println(rs.getString("name"));
        	 System.out.println(rs.getInt("sal"));
        	 System.out.println(rs.getString("dept"));
        	 System.out.println(rs.getInt("phone"));
        	 System.out.println("------------");
         }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
