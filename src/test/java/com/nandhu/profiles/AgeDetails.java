package com.nandhu.profiles;

import java.util.List;

import com.nandhu.impl.ProfilesImpl;

public class AgeDetails {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		List<ProfilesImpl> list = p.getAgeDetails();
		for (ProfilesImpl pi : list) {
			System.out.println(pi.toString3());
		}
		
	}

}
