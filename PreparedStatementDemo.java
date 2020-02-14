package com.ibm.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
	Connection dbCon;
	PreparedStatement pstmt;
	
	public PreparedStatementDemo() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ibm20Jan?serverTimezone=UTC","root","");
		}
		catch(SQLException e) {
			System.out.println("Some issues while connecting: "+e.getMessage());
		}
	}
	
	void createOurStatement(String qry) {
		try {
			pstmt = dbCon.prepareStatement(qry);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PreparedStatementDemo demo = new PreparedStatementDemo();
		
		demo.updateData();
	}
	
	private void queryTable() {
		//write the query to fetch details from table
		String fetchQry = "select * from employeeDetails1 where employeeNumber=?";
		
		try {
			this.createOurStatement(fetchQry);
			pstmt.setInt(2, 4);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("Name: "+rs.getString("employeeName"));
			}
		}
		catch(SQLException e) {
			System.out.println("Issues while creating the prepared Statement:"+e.getMessage());		
		}
			
		try {
			dbCon.close();
		}
		catch(SQLException e) {
			System.out.println("Issues while closing the connection:"+e.getMessage());
		}
	}
	void updateData() {
		String updateQry = "update employeeDetails1 set employeeName= ? where employeeNumber=?";
		try {
			pstmt = dbCon.prepareStatement(updateQry);
			
			pstmt.setString(1,"mayank Awasthi");
			pstmt.setInt(2, 2);
			if(pstmt.executeUpdate()>0)
				System.out.println("Updated successfully..");
			else
				System.out.println("Some issue while updating the row..");
		}
		catch(SQLException e) {
			System.out.println("issues while creating the prepared statement:"+ e.getMessage());
		}
	}

}









