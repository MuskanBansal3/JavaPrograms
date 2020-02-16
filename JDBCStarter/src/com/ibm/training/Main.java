package com.ibm.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		

		try {
			//Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connect to the db
			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ibm20Jan?serverTimezone=UTC", "root", "");
			
//			System.out.println("Successfully Connected to DataBase...");
			
	//new Main().getAllData(dbCon);
		new Main().insertData(dbCon);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Exception while loading driver" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Exception while connecting to db : " + e.getMessage());
		}

	}
	
//	Gets all rows from the table : userDetails
	void getAllData(Connection dbCon) {
		// Create a Statement
		try {
			Statement stmt = dbCon.createStatement();
			
			//Write the query to fetch data from table: userDetails
			String fetchQry = "select * from studentDetails";
			
			//Execute the query
			ResultSet rs = stmt.executeQuery(fetchQry);
			
			//Traverse through the ResultSet
			while(rs.next()) {
				System.out.print("User ID : " + rs.getInt("ID"));
				System.out.println(", User Name : " + rs.getString("Name"));
			}
			
			//Close the connection
			dbCon.close();
			
			
		} catch (SQLException e) {
			System.out.println("Issues creating the statement :" + e.getMessage());
		}
	}
	
	
	
	
	// Inserts a new row into the table: userDetails
	void insertData(Connection dbCon) {
		//Write the query to insert a new row in table
		String insertQry = "insert into studentDetails values('Jaya',78,'Bangalore')";
		
		//Create the Statement
		try {
			Statement stmt = dbCon.createStatement();
			
			//Execute the query
			if(stmt.executeUpdate(insertQry) > 0) {
				System.out.println("Successfully inserted a new row...");
			}
			else {
				System.out.println("Some issues while inserting...");
			}
			
		} catch (SQLException e) {
			System.out.println("Issues creating the statement :" + e.getMessage());
		}
	}

	
	

}