package com.chainsys.matrimonialmanagement.profiles;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.profiles.ProfilesImpl;

public class ProfileSalaryDetails {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter salary=");
		int salary=s.nextInt();
		s.nextLine();
		System.out.println("Enter Gender(M/F)=");
		String g=s.nextLine();
		p.getSalaryDetails(salary,g);
	}

}
