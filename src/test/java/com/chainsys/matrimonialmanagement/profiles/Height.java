package com.chainsys.matrimonialmanagement.profiles;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.profiles.ProfilesImpl;

public class Height {

	public static void main(String[] args) {
		
		double h;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Gender(M/F)=");
		String g=s.nextLine();
		System.out.println("Enter height=");
		h=s.nextDouble();
		ProfilesImpl p=new ProfilesImpl();
		p.getHeight(h,g);
	}

}
