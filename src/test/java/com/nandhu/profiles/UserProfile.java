package com.nandhu.profiles;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;


public class UserProfile {

	public static void main(String[] args) {
ProfilesImpl p=new ProfilesImpl();
@SuppressWarnings("resource")
Scanner s=new Scanner(System.in);
Logger.debug("Enter Name:");
String name=s.nextLine();
p.getProfile(name);
	}

}
