package com.nandhu.profiles;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;


public class ProfileSalaryDetails {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter salary=");
		int salary=s.nextInt();
		s.nextLine();
		Logger.debug("Enter Gender(M/F)=");
		String g=s.nextLine();
		p.getSalaryDetails(salary,g);
	}

}
