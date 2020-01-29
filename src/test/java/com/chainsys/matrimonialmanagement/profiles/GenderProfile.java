package com.chainsys.matrimonialmanagement.profiles;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.profiles.ProfilesImpl;

public class GenderProfile {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Gender(M/F)=");
		String g=s.nextLine();
		ProfilesImpl p=new ProfilesImpl();
		p.getGenderProfile(g);
	}

}
