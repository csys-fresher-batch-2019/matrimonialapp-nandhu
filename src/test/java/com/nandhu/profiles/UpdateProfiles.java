package com.nandhu.profiles;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;


public class UpdateProfiles {

	public static void main(String[] args) {

		ProfilesImpl p=new ProfilesImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter User Name:");
		String userName=s.nextLine();
		Logger.debug("Enter MOb_No:");
		Long mobNo=s.nextLong();
		s.nextLine();
		Logger.debug("Enter Mail:");
		String mail=s.nextLine();
		Logger.debug("Enter Occupation:");
		String occupation=s.nextLine();
		Logger.debug("Enter Salary:");
		int salary=s.nextInt();
		p.updateProfiles(occupation,salary,userName,mobNo);
	}

}
