package com.chainsys.matrimonialmanagement.profiles;

import java.util.Scanner;

public class TestUserLogin {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter email:");
		String email=s.nextLine();
		s.nextLine();
		System.out.println("Enter password:");
		String pass=s.nextLine();
		p.userLogin(email, pass);
	}

}
