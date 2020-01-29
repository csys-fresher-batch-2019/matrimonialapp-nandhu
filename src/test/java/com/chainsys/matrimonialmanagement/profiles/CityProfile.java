package com.chainsys.matrimonialmanagement.profiles;

import java.util.Scanner;

public class CityProfile {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter gender:");
		String g=s.nextLine();
		System.out.println("Enter city:");
		String c=s.nextLine();
		p.getCityProfile(g,c);
	}

}
