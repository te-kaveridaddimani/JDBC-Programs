package com.tyss.dynamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparestmtCommandlineexmp {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//1.load the driver
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //2.get the connection via driver
		 try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 //3.issue sql query via connection
		
		 try {
			 String query="select * from employee where id=?";
		 System.out.println("after select...");
		 pstmt=con.prepareStatement(query);
		 //reading the parameter input through command line argument
		 String eid=args[0];
		 int empid=Integer.parseInt(eid);
		 //binding the parameter from employee id
		 pstmt.setInt(1, empid);
		 rs=pstmt.executeQuery();
		 
		 System.out.println("before resultset processing..");
		 //4.process resultset
		 if(rs.next())
		 {
			 int emplid=rs.getInt("id");
			 String empname=rs.getString("name");
			 int salary=rs.getInt("sal");
			 int ph=rs.getInt("phone");
			 
			 System.out.println("emp id :"+emplid);
			 System.out.println("emp name:"+empname);
			 System.out.println("emp sala :"+salary);
			 System.out.println("emp phone :"+ph);
		 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 //5.
		 finally {
				if(con!=null)
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(pstmt!=null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(rs!=null)
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 }
		 
		 
	}

}
