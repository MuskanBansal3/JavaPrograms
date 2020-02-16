package com.ibm.training;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;


 class EmployeeInfo {
	PreparedStatement pstmt;
	static Connection dbCon;
	
	public Connection ServiceConnection(Connection dbCon) {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ibm20Jan?serverTimezone=UTC", "root", "");
		} catch (SQLException e) {
			System.out.println("problem while connection"  + e.getMessage());
		}
		return dbCon;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		EmployeeInfo Info = new EmployeeInfo();
		dbCon = Info.ServiceConnection(dbCon);
		while(true) {
			System.out.println("************************************************************");
			System.out.println("Press 1 for inserting new employee details");
			System.out.println("Press 2 for updating employee details");
			System.out.println("Press 3 for deleting new employee details");
			System.out.println("Press 4 for displaying new employee details");
			int n = scan.nextInt();
			switch(n) {
			case 1: 
				Info.insertData(dbCon);
				break;
			case 2:
				Info.updateData(dbCon);
				break;
			case 3:
				Info.deleteData(dbCon);
				break;
			case 4:
				Info.getData(dbCon);
				break;
			}
			
			System.out.println("If to want to go out of the database press 0 else Press 1");
			int m = scan.nextInt();
			scan.nextLine();
			if(m==0)
				break;
		}
	}


	
	public void insertData(Connection dbCon) {
		Scanner scan = new Scanner(System.in);
		String query = "insert into employeedetails1 value(?,?,?,?)";
		try {
		System.out.println("enter the employee name");
		String name = scan.nextLine();
		System.out.println("enter the the employee number");
		int number = scan.nextInt();
		scan.nextLine();
		System.out.println("enter the employee designation");
		String designation = scan.nextLine();
		System.out.println("enter the employee salary");
		int salary = scan.nextInt();
		scan.nextLine();
		pstmt = dbCon.prepareStatement(query);
		pstmt.setString(1,name);
		pstmt.setInt(2,number);
		pstmt.setString(3,designation);
		pstmt.setInt(4,salary);
		
		if(pstmt.executeUpdate()>0)
			System.out.println("row inserted");
		else
			System.out.println("row not inserted");
		} catch (SQLException e) {
			System.out.println("problem while inserting " + e.getMessage());
		}
	}
	
	public void updateData(Connection dbCon) {
		Scanner scan = new Scanner(System.in);
		String querySalary = "update employeedetails1 set employeeSalary=? where employeeNumber=?";
		String queryName = "update employeedetails1 set employeeName=? where employeeNumber=?";
		String queryDesignation = "update employeedetails1 set employeeDesignation=? where employeeNumber=?";
		String queryNumber = "update employeedetails1 set employeeNumber=? where employeeNumber=?";
		
		System.out.println("Press 1 to update employee salary ");
		System.out.println("Press 2 to update employee name");
		System.out.println("Press 3 to update employee desigantion");
		System.out.println("Press 4 to update employee number ");
		int n = scan.nextInt();
		scan.nextLine();
		switch(n) {
		case 1:
			try {
				pstmt = dbCon.prepareStatement(querySalary);
				System.out.println("Enter the new Salary");
				int salary = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the employee number to be changed");
				int number = scan.nextInt();
				scan.nextLine();
				pstmt.setInt(2, number);
				pstmt.setInt(1, salary);
				if(pstmt.executeUpdate()>0)
					System.out.println("row updated");
				else
					System.out.println("not row updated");
			} catch (SQLException e) {
				System.out.println("problem while updating salary" + e.getMessage());
			}
			break;
		case 2:
			try {
				pstmt = dbCon.prepareStatement(queryName);
				System.out.println("Enter the new Name");
				String name = scan.nextLine();
				System.out.println("Enter the employee number to be changed");
				int number = scan.nextInt();
				scan.nextLine();
				pstmt.setInt(2, number);
				pstmt.setString(1, name);
				if(pstmt.executeUpdate()>0)
					System.out.println("row updated");
				else
					System.out.println("not row updated");
			} catch (SQLException e) {
				System.out.println("problem while updating name" + e.getMessage());
			}
			break;
		case 3:
			try {
				pstmt = dbCon.prepareStatement(queryDesignation);
				System.out.println("Enter the new Designation");
				String designation = scan.nextLine();
				System.out.println("Enter the employee number to be changed");
				int number = scan.nextInt();
				scan.nextLine();
				pstmt.setInt(2, number);
				pstmt.setString(1, designation);
				if(pstmt.executeUpdate()>0)
					System.out.println("row updated");
				else
					System.out.println("not row updated");
			} catch (SQLException e) {
				System.out.println("problem while updating designation" + e.getMessage());
			}
			break;
		case 4:
			try {
				pstmt = dbCon.prepareStatement(queryNumber);
				System.out.println("Enter the new Number");
				int newNumber = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter the employee number to be changed");
				int number = scan.nextInt();
				scan.nextLine();
				pstmt.setInt(2, number);
				pstmt.setInt(1, newNumber);
				if(pstmt.executeUpdate()>0)
					System.out.println("row updated");
				else
					System.out.println("not row updated");
			} catch (SQLException e) {
				System.out.println("problem while updating number" + e.getMessage());
			}
			break;
		default:
			break;
			
		}
	}
	
	public void deleteData(Connection dbCon) {
		Scanner scan = new Scanner(System.in);
		String queryNumber = "delete from employeedetails1 where employeeNumber=?";
		String queryName = "delete from employeedetails1 where employeeName=?";
		String querySalary = "delete from employeedetails1 where employeeSalary=?";
		String queryDesignation = "delete from employeedetails1 where employeeDesignation=?";
		
		System.out.println("Press 1 to delete from employee number");
		System.out.println("Press 2 to delete from employee name");
		System.out.println("Press 3 to delete from employee salary");
		System.out.println("Press 4 to delete from employee designation");
		int n= scan.nextInt();
		scan.nextLine();
		switch(n){
		case 1:
			try {
				pstmt = dbCon.prepareStatement(queryNumber);
				System.out.println("Enter the employee number to be deleted");
				int number = scan.nextInt();
				scan.nextLine();
				pstmt.setInt(1, number);
				if(pstmt.executeUpdate()>0)
					System.out.println("row updated");
				else
					System.out.println("not row updated");
			} catch (SQLException e) {
				System.out.println("problem while deleting number" + e.getMessage());
			}
			break;
			
		case 2:
			try {
				pstmt = dbCon.prepareStatement(queryName);
				System.out.println("Enter the employee name to be deleted");
				String name = scan.nextLine();
				pstmt.setString(1, name);
				if(pstmt.executeUpdate()>0)
					System.out.println("row updated");
				else
					System.out.println("not row updated");
			} catch (SQLException e) {
				System.out.println("problem while deleting name" + e.getMessage());
			}
			break;
			
		case 3:
			try {
				pstmt = dbCon.prepareStatement(querySalary);
				System.out.println("Enter the employee salary to be deleted");
				int salary = scan.nextInt();
				scan.nextLine();
				pstmt.setInt(1, salary);
				if(pstmt.executeUpdate()>0)
					System.out.println("row updated");
				else
					System.out.println("not row updated");
			} catch (SQLException e) {
				System.out.println("problem while deleting salary" + e.getMessage());
			}
			break;
			
		case 4:
			try {
				pstmt = dbCon.prepareStatement(queryDesignation);
				System.out.println("Enter the employee designation to be deleted to be changed");
				String designation = scan.nextLine();
				pstmt.setString(1, designation);
				if(pstmt.executeUpdate()>0)
					System.out.println("row updated");
				else
					System.out.println("not row updated");
			} catch (SQLException e) {
				System.out.println("problem while deleting designation" + e.getMessage());
			}
			break;
		default:
			break;
		}
	}
	
	public void getData(Connection dbCon) {
		String query = "select * from employeedetails1";
		try {
			pstmt = dbCon.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("EmployeName is : " + rs.getString("EmployeeName"));
				System.out.println("EmployeNumber is : " + rs.getInt("EmployeeNumber"));
				System.out.println("EmployeDesination is : " + rs.getString("EmployeeDesignation"));
				System.out.println("EmployeSalary is : " + rs.getInt("EmployeeSalary"));
				
			}
		} catch (SQLException e) {
			System.out.println("problem while printing " + e.getMessage() );
		}
		
	}
}
 
	
	


