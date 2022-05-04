package com.revature.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactory {
	static Connection conn = null;
	static Logger log = Logger.getLogger(ConnectionFactory.class);
	
	protected ConnectionFactory() { }
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String dri = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ib";
		String user = "root";
		String password = "root";
		
		if(conn == null) {
			Class.forName(dri);
			conn = DriverManager.getConnection(url, user, password);
			try {
				Class.forName(dri);
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				log.error("CNFE in ConnectionFactory - getConnection", e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error("SQLE in ConnectionFactory - getConnection", e);
			}
			
		}
		return conn;
	}
}