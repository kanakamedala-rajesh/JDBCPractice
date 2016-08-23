package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FriendsBookData {
	public static Connection dbconn;
	public static Statement stmt;
	public static ResultSet rset;

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String dbURL = "jdbc:postgresql://localhost/Friends-Book";
			String user = "postgres";
			String pass = "root";
			dbconn = DriverManager.getConnection(dbURL, user, pass);
			stmt = dbconn.createStatement();
			String query = "select * from chat_rooms";
			rset = stmt.executeQuery(query);
			while (rset.next()) {
				System.out.println(
						"ID: " + rset.getString(1) + " Name: " + rset.getString(2) + " Created: " + rset.getString(3));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				dbconn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
