package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserDetails {
	
	public UserDetails addUserDetails() throws Exception {
		
		Connection con = null;
		Statement stmt1 = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Driver Class Loading
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
			Scanner sc1 = new Scanner(System.in);

			System.out.println("First Name =");
			String firstName = sc1.nextLine();

			System.out.println("Last Name =");
			String lastName =  sc1.nextLine();

			System.out.println("Email Id =");
			String emailID = sc1.nextLine();
			
			System.out.println("Mobile Number =");
			String mobNo =  sc1.nextLine();

			System.out.println("Address= ");
			String address =  sc1.nextLine();

			String sql1 = "insert into UserDetails (`firstName`, `lastName`, `EmailID`, `MobileNo`, `Address`) " + 
			"values ('"	+ firstName + "','" + lastName + "','" +emailID+ "','" + mobNo + "','" + address + "')";
			
			System.out.println(sql1);

			
			/*INSERT INTO `Ecommerce`.`userdetails` (`firstName`, `lastName`, `EmailID`, `MobileNo`, `Address`)
			VALUES ('Rohit', 'Sonawane', 'r2011@gmail.com', '982328128', 'Moshi ,Pune');*/
			
			
			stmt1 = con.createStatement();
			stmt1.executeUpdate(sql1);

			System.out.println("User Details Saved in Database");

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			con.close();
		}
				
		return new UserDetails();
	}

}
