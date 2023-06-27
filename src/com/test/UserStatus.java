package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserStatus {
	static int i = 1; // For Print number

	public UserStatus checkUserStatus() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			System.out.println("Checking User Status .....Please Wait");

			Class.forName("com.mysql.cj.jdbc.Driver"); // load DriverClass
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
			String sql = "select * from userstatus ";
			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // While loop for iteration

				System.out.println(i++ + ".  " + rs.getString(2));
			}

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Status");
			int status = sc.nextInt();

			int a = 1;
			int b = 2;

			if (status == a) { // if New User then Go for Registration
				Registration reg = new Registration();
				try {
					reg.newRegistration(); // New Registration Method
				} catch (Exception e1) {
					System.out.println(e1);
				}

			} else if (status == b) {

				System.out.println(" Login Code");
				LoginCode lc = new LoginCode();

				lc.getLoggedIn();

			}

		} catch (Exception e) {

			System.out.println(e);
		} finally {
			ps.close();
			con.close();
		}

		return new UserStatus();
	}
}
