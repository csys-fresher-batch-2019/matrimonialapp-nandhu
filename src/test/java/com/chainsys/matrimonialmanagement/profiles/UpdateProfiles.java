package com.chainsys.matrimonialmanagement.profiles;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.membership.MembershipPlanImpl;
import com.chainsys.matrimonialmanagement.profiles.ProfilesImpl;

public class UpdateProfiles {

	public static void main(String[] args) {

		ProfilesImpl p=new ProfilesImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter User Name:");
		String userName=s.nextLine();
		System.out.println("Enter MOb_No:");
		Long mobNo=s.nextLong();
		s.nextLine();
		System.out.println("Enter Occupation:");
		String occupation=s.nextLine();
		System.out.println("Enter Salary:");
		int salary=s.nextInt();
		p.updateProfiles(occupation,salary,userName,mobNo);
	}

}
