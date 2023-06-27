package com.test;

public class TestMain {

	static {
		System.out.println("Welcome to E-Commerce"); // Static Block
	}

	public static void main(String[] args) {

		UserStatus rs = new UserStatus();
		try {
			rs.checkUserStatus();
		} catch (Exception e) {
			System.out.println(e);
		}

		UserDetails us1 = new UserDetails(); // Object Created For Method Call from Class

		try {
			// us1.addUserDetails(); // Method Called
		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

}
