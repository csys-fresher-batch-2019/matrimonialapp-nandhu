package com.nandhu.profiles;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;


public class CityProfile {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter gender:");
		String g=s.nextLine();
		Logger.debug("Enter city:");
		String c=s.nextLine();
		p.getCityProfile(g,c);
	}

}
