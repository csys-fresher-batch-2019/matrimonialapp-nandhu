package com.chainsys.matrimonialmanagement.profiles;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.profiles.ProfilesImpl;

public class UserProfile {

	public static void main(String[] args) {
ProfilesImpl p=new ProfilesImpl();
Scanner s=new Scanner(System.in);
System.out.println("Enter Name:");
String name=s.nextLine();
p.getProfile(name);
	}

}
