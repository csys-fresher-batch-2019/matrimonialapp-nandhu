package com.nandhu.profiles;

import java.util.List;
import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.ProfilesImpl;

public class GetFullProfiles {

	public static void main(String[] args) {
		ProfilesImpl p=new ProfilesImpl();
		List<ProfilesImpl> list = p.getFullProfile();
		for (ProfilesImpl pi : list) {
			System.out.println(pi.toString());
		}
			}

}
