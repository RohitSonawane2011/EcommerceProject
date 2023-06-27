package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Registration {
	
	public Registration newRegistration() throws Exception {
		Connection con= null;
		Statement stmt2= null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");      //Driver Class Load
			 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root"); //Connection to DB
			
			 
			 Scanner sc1 =new Scanner(System.in);
			 
			 System.out.println("Enter New User Name >>");
			 String userName = sc1.nextLine();
			 
			 System.out.println("Enter New Password >>");
			 String password = sc1.nextLine();
			 
			 /*INSERT INTO `Ecommerce`.`usercredentials` (`UserName`, `Password`) VALUES ('rohit', '123');*/
			 
			 String sql2=" insert into Ecommerce.UserCredentials (UserName ,Password ) Values ( '"+userName+"','"+ password+"');";
			 
			 //System.out.println(sql2);
			 
			 
			 stmt2= con.createStatement();
			 stmt2.executeUpdate(sql2);
			 
			 System.out.println("New User Created >>"+ userName);
			 
			 
			
			sc1.close();
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		finally {
			con.close();
			stmt2.close();
			
		}		
		return new Registration();
	}
}
