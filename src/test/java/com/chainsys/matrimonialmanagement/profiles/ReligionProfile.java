package com.chainsys.matrimonialmanagement.profiles;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.profiles.ProfilesImpl;

public class ReligionProfile {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Gender(M/F)=");
		String g=s.nextLine();
		System.out.println("Enter Religion=");
		String r=s.nextLine();
		p.getReligion(g,r);
	}

}
