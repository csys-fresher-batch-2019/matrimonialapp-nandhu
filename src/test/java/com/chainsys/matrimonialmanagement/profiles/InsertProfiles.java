package com.chainsys.matrimonialmanagement.profiles;

import java.time.LocalDate;
import java.util.Scanner;

import com.chainsys.matrimonialmanagement.profiles.ProfilesImpl;

public class InsertProfiles {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter user name=");
		p.userName=s.nextLine();
	
		System.out.println("Enter Dob=");
		p.dob=LocalDate.parse(s.nextLine());
		s.nextLine();
		System.out.println("Enter gender(M/F)=");
		p.gender=s.nextLine();
		System.out.println("Enter religion=");
		p.religion=s.nextLine();
		System.out.println("Enter caste=");
		p.caste=s.nextLine();
		System.out.println("Enter country=");
		p.country=s.nextLine();
		System.out.println("Enter mobNo=");
		p.mobNo=s.nextLong();
		System.out.println("Enter Height=");
		p.height=s.nextDouble();
		s.nextLine();
		System.out.println("Enter Education=");
		p.education=s.nextLine();
		
		System.out.println("Enter Occupation=");
		p.occupation=s.nextLine();
	
		System.out.println("Enter Salary=");
		p.salary=s.nextInt();
		s.nextLine();
		System.out.println("Enter Marital Status=");
		p.maritalSts=s.nextLine();
		
		System.out.println("Enter Membership Type(platinum/gold/silver)=");
		p.membershipType=s.nextLine();
		
		
		p.save(p);
	}
}
