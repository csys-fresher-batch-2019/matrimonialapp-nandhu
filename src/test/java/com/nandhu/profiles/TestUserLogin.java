package com.nandhu.profiles;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;


public class TestUserLogin {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter email:");
		String mail=s.nextLine();
		s.nextLine();
		Logger.debug("Enter password:");
		String pass=s.nextLine();
		p.userLogin(mail,pass);
	}

}
