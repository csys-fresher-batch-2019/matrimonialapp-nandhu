package com.nandhu.profiles;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;

public class ChangePassword {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter User Email:");
		String userEmail=s.nextLine();
		Logger.debug("Enter new password:");
		String password=s.nextLine();
		p.changePassword(userEmail, password);
		

	}

}
