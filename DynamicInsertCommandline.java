package com.tyss.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicInsertCommandline {

	public static void main(String[] args) {
		try {
			Connection con=null;
			PreparedStatement pstmt=null;
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			 String query="insert into employee values(?,?,?,?,?)";
			 pstmt=con.prepareStatement(query);
			 
			 //in command line give values in btwn space
			 
			 String eid=args[0];
			 int emid=Integer.parseInt(eid);
			 pstmt.setInt(1,emid);
			 
			 String ename=args[1];
			 pstmt.setString(2,ename);
			 
			 String sala=args[2];
			 int salaray=Integer.parseInt(sala);
			 pstmt.setInt(3,salaray );
			 
			 String dep=args[3];
			 pstmt.setString(4,dep );
			 
			 String p=args[4];
			 int ph=Integer.parseInt(p);
			 pstmt.setInt(5,ph);
			 
			 System.out.println("inserted...");
			 pstmt.executeUpdate();
			
			 System.out.println(emid);
			 System.out.println(ename);
			 System.out.println(salaray);
			 System.out.println(dep);
			 System.out.println(ph);
			 
		}
			 
			catch(Exception e) {
				e.printStackTrace();
			}


	}

}
