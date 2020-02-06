package com.nandhu.profiles;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;


public class UpdateActiveStatus {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter User Id:");
		int userId=s.nextInt();
		Logger.debug("Enter Active Status:");
		int active=s.nextInt();
		p.updateActive(userId, active);
	}

}
