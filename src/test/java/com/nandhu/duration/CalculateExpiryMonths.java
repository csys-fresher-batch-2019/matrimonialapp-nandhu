package com.nandhu.duration;

import java.util.Scanner;

import com.nandhu.impl.Logger;
import com.nandhu.impl.MembershipDurationImpl;

public class CalculateExpiryMonths {
	   @SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		MembershipDurationImpl md=new MembershipDurationImpl();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		Logger.debug("Enter user id=");
		int userId=s.nextInt();
		Logger.debug("Enter plan id=");
		int mdplanId=s.nextInt();
		Logger.debug("Enter month to be added=");
		int monthValidity=s.nextInt();
		md.calculateExpiryDuration(userId,mdplanId,monthValidity);
	}

}
