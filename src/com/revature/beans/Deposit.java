package com.revature.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Deposit {
	public void getBalance(int acc_no) throws SQLException{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/lms";
		String username = "root";
		String password = "root";
		Scanner sc=new Scanner(System.in);
	      Connection con;
		try {
			 con = ConnectionFactory.getConnection();
			 String s = "SELECT amount FROM onlinebanking WHERE id = ?";
		      PreparedStatement ps = con.prepareStatement(s);
		      ps.setInt(1, acc_no);
		      ResultSet rs = ps.executeQuery();
		      int balance = rs.getInt(1);
		   // Load the driver class in JVM memory
				Class.forName(driver);
				// Establish a (network kind of) connection
				Connection conn = DriverManager.getConnection(url, username, password);
				
				// Set-up an interface to execute SQL command
				Statement stmt = conn.createStatement();
				
				int acc_no=0;
				String bank_name="";
				String cus_name="";
				int amount=0;
				
				// Console input to the above 3 variables
				
				// Execute an sql command and get the result
				
				
				int D;
				wD=sc.nextInt();
				balance=balance+D;
				System.out.println("Doposite successfull");
				System.out.println("Total amount is: "+balance);
				
				String sql = "update onlinebanking SET amount=? where acc_no=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,balance);
				pstmt.setInt(2,acc_no);
				int norec = pstmt.executeUpdate();
				if(norec > 0) {
					System.out.println("Updated successfully");
				}
				else {
					System.out.println("Updation failed");
				}
				
				//Clean-up
				stmt.close();
				conn.close();
				


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }

}