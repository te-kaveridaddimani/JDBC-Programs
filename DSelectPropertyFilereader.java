package com.tyss.dynamic;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DSelectPropertyFilereader {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String fileLocation="D:\\FileHandling\\DynamicSelectPropertyFilereader.txt";
		
		FileReader reader=new FileReader(fileLocation);
		Properties prop=new Properties();
		prop.load(reader);
		
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems" ,prop);
		
		String query="select * from employee where id=?";
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1, 60);
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt("id")+": id");
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("sal"));
			System.out.println(rs.getString("dept"));
			System.out.println(rs.getInt("phone"));
		}
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
