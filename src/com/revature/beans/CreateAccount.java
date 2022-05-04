package com.reavture.beans;

import java.util.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateAccount {
	int id;
	String cname;
	String address;
	Date opendate = new Date();
	int openbal;

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/ib";
	String username = "root";
	String password = "root";
	
	try {
		// Load the driver class in JVM memory
		Class.forName(driver);
		// Establish a (network kind of) connection
		Connection conn = DriverManager.getConnection(url, username, password);
		
		// Set-up an interface to execute SQL command
    	//Statement stmt = conn.createStatement();
		
		//int slno = 0;
		//String name = "";
		//String email = "";
		// Console input to the above 3 variables
		
		// Execute an sql command and get the result
		String sql="UPDATE  person set name=?,email=? where slno=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, "siraj");
		pstmt.setString(2,"siraj@gmail.com");
		pstmt.setInt(3,1);
		int norec = pstmt.executeUpdate();
		if(norec > 0) {
			System.out.println("");
		}
		else {
			System.out.println("Insertion failed");
		}
		
		//Clean-up
		pstmt.close();
		conn.close();
		

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}