package com.nandhu.duration;

import java.util.List;
import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.MembershipDurationImpl;


public class RemainigDaysInfo {
	   @SuppressWarnings("unused")
	   
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		MembershipDurationImpl md=new MembershipDurationImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter id=");
		int UserId=s.nextInt();	
		md.getRemainingDays(UserId);
		List<MembershipDurationImpl> list = md.getRemainingDays(UserId);
		for (MembershipDurationImpl member : list) {
			System.out.println(member.toString1());
	
}
		
	}	
	}


