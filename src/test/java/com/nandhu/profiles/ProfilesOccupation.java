package com.nandhu.profiles;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;


public class ProfilesOccupation {
	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter Gender(M/F)=");
		String g=s.nextLine();
		Logger.debug("Enter occupation=");
		String occup1=s.nextLine();
		//String occups=s.nextLine();
		p.getOccupation(g,occup1);
	}
}