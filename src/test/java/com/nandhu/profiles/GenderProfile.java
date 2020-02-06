package com.nandhu.profiles;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;


public class GenderProfile {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter Gender(M/F)=");
		String g=s.nextLine();
		ProfilesImpl p=new ProfilesImpl();
		p.getGenderProfile(g);
	}

}
