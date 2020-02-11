package com.nandhu.profiles;

import java.util.List;
import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;


public class Height {

	public static void main(String[] args) {
		
		double h;
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter Gender(M/F)=");
		String g=s.nextLine();
		Logger.debug("Enter height=");
		h=s.nextDouble();
		ProfilesImpl p=new ProfilesImpl();
		List<ProfilesImpl> list =p.getHeight(h,g);
		for (ProfilesImpl pi : list) {
			System.out.println(pi.toString1());
		}
	}

}
