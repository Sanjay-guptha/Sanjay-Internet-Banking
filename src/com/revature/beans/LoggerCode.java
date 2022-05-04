package com.revature.beans;

import org.apache.log4j.Logger;

import com.revature.beans.ConnectionFactory;

import java.sql.*;

public class OnlineBanking {
	
	Logger log = Logger.getLogger(OnlineBanking.class);
	
	public String validateUser(String username, String password) throws ClassNotFoundException, SQLException {
		log.debug("Validating "+username);
		String role = "";
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "SELECT role FROM user WHERE username = ? AND password = ?" ;
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			log.info(username+" is valid");
			role = rs.getString("role");
		}
		else {
			log.info(username+" is not valid");
		}
		
		return role;
	}
	
	public boolean createUser(String username, String password, String role) throws ClassNotFoundException, SQLException {
		log.debug("Trying to create user with "+username+" and role "+role);
		Connection conn = ConnectionFactory.getConnection();
		String sql = "INSERT INTO user (username, password, role) VALUES (?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		pstmt.setString(3, role);
		if(pstmt.executeUpdate() == 1) {
			log.info("User created successfully with username : "+username+" and role "+role);
			return true;
		}
		else {
			log.info("User creation faile with username : "+username+" and role "+role);
			return false;
		}
		
	}
	
	public boolean deleteUser(String username) {
		System.out.println("Deleting user "+username);
		return true;
	}

}