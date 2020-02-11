package com.nandhu.profiles;

import java.util.List;
import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;


public class ProfilesNotInOccupation {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter Gender(M/F)=");
		String g=s.nextLine();
		Logger.debug("Enter occupation=");
		String occup1=s.nextLine();
		List<ProfilesImpl> list =p.getNotInOccupation(g,occup1);
		for (ProfilesImpl pi : list) {
			System.out.println(pi.toString1());
		}
			}
		
		}
