package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginCode {

	public LoginCode getLoggedIn() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
			String sql = "select* from UserCredentials";
			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			// int userID = rs.getInt(1);
			String userName ="rohit";   //rs.getString(2);   // Only Single UserName & Password saved in DB
			String password = "123";   //rs.getString(3);
			
			System.out.println(userName);
			System.out.println(password);

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter User Name >>");
			String userName1 = sc.next();

			System.out.println("Enter Password >>");
			String password1 = sc.next();

			if (userName1 == userName && password1 == password) {

				System.out.println("Display Product List");

			} else {
				System.out.println("Please Enter Valid Input");

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			con.close();
			ps.close();

		}

		return new LoginCode();

	}

}
