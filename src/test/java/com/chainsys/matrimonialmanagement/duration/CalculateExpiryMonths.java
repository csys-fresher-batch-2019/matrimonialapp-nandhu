package com.chainsys.matrimonialmanagement.duration;

import java.util.Scanner;

import com.chainsys.matrimonialmanagement.duration.MembershipDurationImpl;

public class CalculateExpiryMonths {

	public static void main(String[] args) {
		
		MembershipDurationImpl md=new MembershipDurationImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter user id=");
		int userId=s.nextInt();
		System.out.println("Enter plan id=");
		int mdplanId=s.nextInt();
		System.out.println("Enter month to be added=");
		int monthValidity=s.nextInt();
		md.calculateExpiryDuration(userId,mdplanId,monthValidity);
	}

}
