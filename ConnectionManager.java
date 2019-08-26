package com.collabera.jdbc;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

import java.sql.*;

public class ConnectionManager {
	
	static final String URL = "jdbc:mysql://localhost:3306/sakila";
	static final String USERNAME = "root";
	static final String PASSWORD ="root";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection was made!");
			
			//----------create statement-------------------------
			Statement statement = conn.createStatement();
			
			
			
			
			String query = "SELECT * FROM ACTOR";
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				String fn = rs.getString("first_name");
				String ln = rs.getString("last_name");
				
				int id = rs.getInt(1);
				System.out.println(id + " "+ fn +" "+ ln);

			}
			
			statement.close();
			
			System.out.println("Statement was closed");
			
			/*
			//---------execute method----------------------------
			boolean flag = statement.execute("select* from actor");
			if(flag == false) 
			{
				System.out.println("Here are the rows "+ statement.getUpdateCount());
			}
			
			//--------executeUpdate Method-------------
			//insert
			int count = statement.executeUpdate("Insert into actor(first_name, last_name) values ('Danny', Murtagh')");
            System.out.println("Row Inserted and now the count is  " + count);
            
            //-----Update------------------------------
            count = statement.executeUpdate("Update actor set first_name = 'Billy' where first_name = Danny'");
            System.out.println("Row Updated and now the count is  " + count);
            
            //-----delete---------------------------------
            count = statement.executeUpdate("Delete from actor where first_name = 'Sissy'");
            System.out.println("Row deleted and now the count is  " + count);
        	*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = ConnectionManager.getConnection(); //because its static
		//we did stuff here
		
		
		try {
			conn.close();
			System.out.println("Connection was closed!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
