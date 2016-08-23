package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateSearchEngine {
	public static Connection dbconn;
	public static Statement stmt;

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String dbURL = "jdbc:postgresql://localhost/MyDB";
			String user = "postgres";
			String pass = "root";
			dbconn = DriverManager.getConnection(dbURL, user, pass);
			stmt = dbconn.createStatement();
			// Step4: Read the data to update
			Scanner in = new Scanner(System.in);
			int id = 1;
			System.out.println("Enter Search Engine Name to modify: ");
			String name = in.nextLine();
			System.out.println("Enter Search Engine Url to update: ");
			String url = in.nextLine();
			in.close();
			StringBuilder query = new StringBuilder(
					"UPDATE SEARCH_ENGINE SET name='" + name + "',url='" + url + "' where id=" + id);
			System.out.println(query);
			// Step5: Run the above query to update the data
			int i = stmt.executeUpdate(query.toString());
			System.out.println(i + " record is updated into 'Search_Engine' successfully..");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
