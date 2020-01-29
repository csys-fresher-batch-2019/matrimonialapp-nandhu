package com.chainsys.matrimonialmanagement.profiles;

import java.util.Scanner;

public class ProfilesNotInOccupation {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Gender(M/F)=");
		String g=s.nextLine();
		String occup;
		System.out.println("Enter occupation=");
		String occup1=s.nextLine();
		//String occups=s.nextLine();
		p.getNotInOccupation(g,occup1);
	}

}
