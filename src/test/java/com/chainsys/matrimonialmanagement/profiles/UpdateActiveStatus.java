package com.chainsys.matrimonialmanagement.profiles;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.profiles.ProfilesImpl;

public class UpdateActiveStatus {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter User Id:");
		int userId=s.nextInt();
		System.out.println("Enter Active Status:");
		int active=s.nextInt();
		p.updateActive(userId, active);
	}

}
