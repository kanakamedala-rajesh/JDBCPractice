package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertusingPSTMT {

	public static Connection dbconn;

	public static PreparedStatement stmt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.postgresql.Driver");
			String dbURL = "jdbc:postgresql://localhost/MyDB";
			String user = "postgres";
			String pass = "root";

			Scanner in = new Scanner(System.in);
			int id = 17;
			System.out.println("Enter Search Engine Name to modify: ");
			String name = in.nextLine();
			System.out.println("Enter Search Engine Url to update: ");
			String url = in.nextLine();
			in.close();

			dbconn = DriverManager.getConnection(dbURL, user, pass);
			// Step3: Defining a PreparedStatementobject
			String query = "Insert into SEARCH_ENGINE values (?, ?, ?)";
			stmt = dbconn.prepareStatement(query);

			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, url);

			int i = stmt.executeUpdate();
			System.out.println(i);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
